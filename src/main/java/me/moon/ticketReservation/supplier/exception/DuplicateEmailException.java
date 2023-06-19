package me.moon.ticketReservation.supplier.exception;

import me.moon.ticketReservation.common.exception.BusinessException;
import me.moon.ticketReservation.common.exception.ErrorCode;

public class DuplicateEmailException extends BusinessException {
    public DuplicateEmailException(String email){
        super(email, ErrorCode.DUPLICATE_EMAIL);
    }
}
