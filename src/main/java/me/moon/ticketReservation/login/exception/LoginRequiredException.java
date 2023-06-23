package me.moon.ticketReservation.login.exception;

import me.moon.ticketReservation.common.exception.BusinessException;
import me.moon.ticketReservation.common.exception.ErrorCode;

public class LoginRequiredException extends BusinessException {
    public LoginRequiredException(ErrorCode errorCode) {
        super(errorCode);
    }
}
