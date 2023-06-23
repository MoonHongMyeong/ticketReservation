package me.moon.ticketReservation.venues.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.login.annotation.LoginRequired;
import me.moon.ticketReservation.login.annotation.LoginUser;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.venues.dto.VenuesResponseDto;
import me.moon.ticketReservation.venues.dto.VenuesSaveRequestDto;
import me.moon.ticketReservation.venues.service.VenuesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @LoginRequired
    @DeleteMapping("/venues/{venuesId}")
    public ResponseEntity<String> deleteVenues(@LoginUser SessionUser sessionUser, @PathVariable(value = "venuesId") String venuesId){
        venuesService.delete(sessionUser, venuesId);
        return ResponseEntity.ok("공연장 삭제 성공.");
    }

    @LoginRequired
    @GetMapping("/venues")
    public ResponseEntity<List<VenuesResponseDto>> searchVenusList(@RequestParam(name = "id", required = false) String id, @RequestParam(name = "name", required = false) String name, @RequestParam(name = "type", required = false) String type, @RequestParam(name = "addressName", required = false) String addressName){
        List<VenuesResponseDto> response = venuesService.search(id, name, type, addressName);
        return ResponseEntity.ok(response);
    }
}
