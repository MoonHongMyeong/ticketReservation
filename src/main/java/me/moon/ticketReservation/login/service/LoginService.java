package me.moon.ticketReservation.login.service;

import me.moon.ticketReservation.login.dto.LoginRequestDto;
import me.moon.ticketReservation.login.dto.LoginResponseDto;

public interface LoginService {
    LoginResponseDto login(String userRole, LoginRequestDto dto);

    void logout();
}
