package me.moon.ticketReservation.venues.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.common.exception.ErrorCode;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.login.exception.WrongUserRoleException;
import me.moon.ticketReservation.supplier.entity.Role;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.supplier.service.SupplierFindDao;
import me.moon.ticketReservation.venues.dto.VenuesResponseDto;
import me.moon.ticketReservation.venues.dto.VenuesSaveRequestDto;
import me.moon.ticketReservation.venues.entity.Venues;
import me.moon.ticketReservation.venues.exception.DuplicateVenuesException;
import me.moon.ticketReservation.venues.repository.VenuesMapper;
import org.springframework.stereotype.Service;

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
}
