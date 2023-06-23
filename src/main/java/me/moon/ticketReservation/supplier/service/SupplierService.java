package me.moon.ticketReservation.supplier.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.common.exception.ErrorCode;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.login.exception.UnauthorizedAccessException;
import me.moon.ticketReservation.supplier.dto.SupplierResponseDto;
import me.moon.ticketReservation.supplier.dto.SupplierSaveRequestDto;
import me.moon.ticketReservation.supplier.dto.SupplierUpdateRequestDto;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.supplier.exception.DuplicateEmailException;
import me.moon.ticketReservation.supplier.exception.WithdrawalException;
import me.moon.ticketReservation.supplier.repository.SupplierMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierService {
    private final SupplierMapper supplierMapper;

    public SupplierResponseDto signUp(SupplierSaveRequestDto dto) {

        if ( isDuplicateEmail(dto.getEmail()) ) {
            throw new DuplicateEmailException(dto.getEmail());
        }

        Supplier supplier = dto.toEntity();
        supplierMapper.signUp(supplier);
        return new SupplierResponseDto().of(supplier);
    }

    public SupplierResponseDto update(SessionUser sessionUser, String supplierId, SupplierUpdateRequestDto dto) {
        Supplier supplier = supplierMapper.findById(supplierId);
        if ( !compareUserAndSessionUser(sessionUser, supplier) ) {
            throw new UnauthorizedAccessException(sessionUser.getEmail(), ErrorCode.UNAUTHORIZED_ACCESS);
        }
        supplier.update(dto);
        supplierMapper.update(supplier);
        return new SupplierResponseDto().of(supplier);
    }

    private boolean compareUserAndSessionUser(SessionUser sessionUser, Supplier supplier) {
        return sessionUser.getEmail().equals(supplier.getEmail());
    }

    private boolean isDuplicateEmail(String email) {
        return supplierMapper.isDuplicateEmail(email);
    }


    public void delete(SessionUser sessionUser, String supplierId) {
        Supplier supplier = supplierMapper.findById(supplierId);
        if ( !compareUserAndSessionUser(sessionUser, supplier) ) {
            throw new UnauthorizedAccessException(sessionUser.getEmail(), ErrorCode.UNAUTHORIZED_ACCESS);
        }
        int result = supplierMapper.deleteById(supplierId);
        if (result != 1){
            throw new WithdrawalException(supplierId);
        }
    }
}
