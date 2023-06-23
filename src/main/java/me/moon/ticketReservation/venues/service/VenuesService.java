package me.moon.ticketReservation.venues.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.common.exception.ErrorCode;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.login.exception.UnauthorizedAccessException;
import me.moon.ticketReservation.login.exception.WrongUserRoleException;
import me.moon.ticketReservation.supplier.entity.Role;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.supplier.service.SupplierFindDao;
import me.moon.ticketReservation.venues.dto.VenuesResponseDto;
import me.moon.ticketReservation.venues.dto.VenuesSaveRequestDto;
import me.moon.ticketReservation.venues.entity.Venues;
import me.moon.ticketReservation.venues.exception.DuplicateVenuesException;
import me.moon.ticketReservation.venues.exception.VenuesNotFoundException;
import me.moon.ticketReservation.venues.repository.VenuesMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VenuesService {
    private final VenuesMapper venuesMapper;
    private final SupplierFindDao supplierFindDao;
    private final VenuesFindDao venuesFindDao;

    public VenuesResponseDto registration(SessionUser sessionUser, VenuesSaveRequestDto dto) {
        if ( !isStageManager(sessionUser) ){
            throw new WrongUserRoleException(sessionUser.getEmail(), ErrorCode.WRONG_USER_ROLE);
        }
        if ( isDuplicateVenues(sessionUser, dto) ){
            throw new DuplicateVenuesException(ErrorCode.DUPLICATE_VENUES);
        }
        Supplier supplier = supplierFindDao.findById(sessionUser.getId().toString());
        Venues venues = dto.toEntity(sessionUser);
        venuesMapper.save(venues);

        return VenuesResponseDto.of(venues, supplier);
    }

    private boolean isStageManager(SessionUser sessionUser) {
        return sessionUser.getRole().equals(Role.STAGE_MANAGER.toString());
    }

    private boolean isDuplicateVenues(SessionUser sessionUser, VenuesSaveRequestDto dto) {
        Venues venues = dto.toEntity(sessionUser);
        return venuesFindDao.isDuplicateVenues(venues);
    }

    public void delete(SessionUser sessionUser, String venuesId) {
        Venues venues = venuesFindDao.findById(venuesId);
        if ( !compareSessionUserIdAndManagerId(sessionUser.getId(), venues.getManager().getId()) ){
            throw new UnauthorizedAccessException("venuesId : "+venuesId, ErrorCode.UNAUTHORIZED_ACCESS);
        }
        int result = venuesMapper.deleteById(venuesId);
        if ( result != 1 ){
            throw new VenuesNotFoundException(ErrorCode.VENUS_NOT_FOUND);
        }
    }

    private boolean compareSessionUserIdAndManagerId(Long sessionUserId, Long managerId) {
        return sessionUserId.equals(managerId);
    }

    public List<VenuesResponseDto> search(String id, String name, String type, String addressName) {
        //쿼리에서 서치하고 엔티티를 DTO로 바꾸는 과정에서 DB SELECT
        Map<String, String> searchKeyword = new HashMap<>();
        searchKeyword.put("id", id);
        searchKeyword.put("name", name);
        searchKeyword.put("type", type);
        searchKeyword.put("addressName", addressName);
        List<Venues> venuesList = venuesMapper.search(searchKeyword);

        return venuesList.stream()
                .map(venues -> VenuesResponseDto.of(venues))
                .collect(Collectors.toList());
    }
}
