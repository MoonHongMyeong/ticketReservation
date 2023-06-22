package me.moon.ticketReservation.login.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.login.dto.LoginRequestDto;
import me.moon.ticketReservation.login.dto.LoginResponseDto;
import me.moon.ticketReservation.login.service.LoginService;
import me.moon.ticketReservation.login.exception.WrongUserRoleException;
import me.moon.ticketReservation.common.exception.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class LoginController {
    private final LoginService loginService;
    @PostMapping("/{userRole}/login")
    public ResponseEntity<LoginResponseDto> login(@PathVariable(value = "userRole") String userRole, @RequestBody LoginRequestDto dto){
        LoginResponseDto response = loginService.login(userRole, dto);
        return ResponseEntity.ok(response);
    }
}
