package me.moon.ticketReservation.login.exception;

import me.moon.ticketReservation.common.exception.BusinessException;
import me.moon.ticketReservation.common.exception.ErrorCode;

public class UnauthorizedAccessException extends BusinessException {
    public UnauthorizedAccessException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
