package me.moon.ticketReservation.login.exception;

import me.moon.ticketReservation.common.exception.BusinessException;
import me.moon.ticketReservation.common.exception.ErrorCode;

public class WrongLoginException extends BusinessException {
    public WrongLoginException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
