package me.moon.ticketReservation.venues.exception;

import me.moon.ticketReservation.common.exception.BusinessException;
import me.moon.ticketReservation.common.exception.ErrorCode;

public class DuplicateVenuesException extends BusinessException {
    public DuplicateVenuesException(ErrorCode errorCode) {
        super(errorCode);
    }
}
