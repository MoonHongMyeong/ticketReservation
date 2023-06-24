package me.moon.ticketReservation.performance.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.common.exception.ErrorCode;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.login.exception.UnauthorizedAccessException;
import me.moon.ticketReservation.login.exception.WrongUserRoleException;
import me.moon.ticketReservation.performance.dto.PerformanceResponseDto;
import me.moon.ticketReservation.performance.dto.PerformanceSaveRequestDto;
import me.moon.ticketReservation.performance.entity.Performance;
import me.moon.ticketReservation.performance.exception.DuplicatePerformanceException;
import me.moon.ticketReservation.performance.exception.PerformanceNotFoundException;
import me.moon.ticketReservation.performance.repository.PerformanceMapper;
import me.moon.ticketReservation.supplier.entity.Role;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.supplier.service.SupplierFindDao;
import me.moon.ticketReservation.venues.entity.Venues;
import me.moon.ticketReservation.venues.service.VenuesFindDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PerformanceService {
    private final PerformanceMapper performanceMapper;
    private final SupplierFindDao supplierFindDao;
    private final VenuesFindDao venuesFindDao;

    @Transactional(rollbackFor = Exception.class)
    public PerformanceResponseDto registration(SessionUser sessionUser, String venuesId, PerformanceSaveRequestDto dto) {
        if ( !isShowManager(sessionUser) ){
            throw new WrongUserRoleException(sessionUser.getEmail(), ErrorCode.WRONG_USER_ROLE);
        }
        Supplier showManager = supplierFindDao.findById(sessionUser.getId().toString());
        Venues venues = venuesFindDao.findById(venuesId);
        Performance performance = dto.toEntity(showManager, venues);

        if ( isExistPerformance(performance) ){
            throw new DuplicatePerformanceException(showManager.getId().toString(), ErrorCode.DUPLICATE_PERFORMANCE);
        }

        performanceMapper.save(performance);

        Performance response = performanceMapper.findById(performance.getId());

        return PerformanceResponseDto.of(response);
    }

    private boolean isExistPerformance(Performance performance) {
        return performanceMapper.isExistPerformance(performance);
    }

    private boolean isShowManager(SessionUser sessionUser) {
        return sessionUser.getRole().equals(Role.SHOW_MANAGER.toString());
    }

    public void delete(SessionUser sessionUser, String venuesId, String performanceId) {
        Performance performance = performanceMapper.findById(Long.parseLong(performanceId));

        if ( !compareSessionUserAndPerformanceManager(sessionUser, performance.getManager()) ){
            throw new UnauthorizedAccessException(sessionUser.getId().toString(), ErrorCode.UNAUTHORIZED_ACCESS);
        }

        int result = performanceMapper.deleteById(Long.parseLong(performanceId));

        if ( result != 1 ){
            throw new PerformanceNotFoundException(venuesId, ErrorCode.VENUS_NOT_FOUND);
        }
    }

    private boolean compareSessionUserAndPerformanceManager(SessionUser sessionUser, Supplier manager) {
        return sessionUser.getId().equals(manager.getId());
    }
}
