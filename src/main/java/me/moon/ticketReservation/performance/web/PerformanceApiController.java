package me.moon.ticketReservation.performance.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.login.annotation.LoginRequired;
import me.moon.ticketReservation.login.annotation.LoginUser;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.performance.dto.PerformanceResponseDto;
import me.moon.ticketReservation.performance.dto.PerformanceSaveRequestDto;
import me.moon.ticketReservation.performance.service.PerformanceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class PerformanceApiController {
    private final PerformanceService performanceService;

    @LoginRequired
    @PostMapping("/venues/{venuesId}/performance")
    public ResponseEntity<PerformanceResponseDto> performanceRegistration(@LoginUser SessionUser sessionUser, @PathVariable(value = "venuesId") String venuesId, @RequestBody PerformanceSaveRequestDto dto){
        PerformanceResponseDto response = performanceService.registration(sessionUser, venuesId, dto);
        return ResponseEntity.ok(response);
    }

}
