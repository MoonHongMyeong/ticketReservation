package me.moon.ticketReservation.venues.exception;

import me.moon.ticketReservation.common.exception.BusinessException;
import me.moon.ticketReservation.common.exception.ErrorCode;

public class VenuesNotFoundException extends BusinessException {
    public VenuesNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
