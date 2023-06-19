package me.moon.ticketReservation.supplier.exception;

import me.moon.ticketReservation.common.exception.BusinessException;
import me.moon.ticketReservation.common.exception.ErrorCode;

public class WithdrawalException extends BusinessException {
    public WithdrawalException(String userId){
        super(userId, ErrorCode.WITHDRAWAL);
    }
}
