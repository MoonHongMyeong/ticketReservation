package me.moon.ticketReservation.performance.exception;

import me.moon.ticketReservation.common.exception.BusinessException;
import me.moon.ticketReservation.common.exception.ErrorCode;

public class DuplicatePerformanceException extends BusinessException {
    public DuplicatePerformanceException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
