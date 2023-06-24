package me.moon.ticketReservation.performance.exception;

import me.moon.ticketReservation.common.exception.BusinessException;
import me.moon.ticketReservation.common.exception.ErrorCode;

public class PerformanceNotFoundException extends BusinessException {
    public PerformanceNotFoundException(String message, ErrorCode errorCode) {
        super(message, errorCode);
    }
}
