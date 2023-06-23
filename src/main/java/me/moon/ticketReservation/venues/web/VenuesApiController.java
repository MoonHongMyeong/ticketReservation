package me.moon.ticketReservation.venues.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.login.annotation.LoginRequired;
import me.moon.ticketReservation.login.annotation.LoginUser;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.venues.dto.VenuesResponseDto;
import me.moon.ticketReservation.venues.dto.VenuesSaveRequestDto;
import me.moon.ticketReservation.venues.service.VenuesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class VenuesApiController {
    private final VenuesService venuesService;

    @LoginRequired
    @PostMapping("/venues")
    public ResponseEntity<VenuesResponseDto> venuesRegistration(@LoginUser SessionUser sessionUser, @RequestBody VenuesSaveRequestDto dto){
        VenuesResponseDto response = venuesService.registration(sessionUser, dto);
        return ResponseEntity.ok(response);
    }
}
