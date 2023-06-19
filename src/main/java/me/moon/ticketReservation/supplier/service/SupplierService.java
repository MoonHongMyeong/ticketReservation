package me.moon.ticketReservation.supplier.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.supplier.dto.SupplierResponseDto;
import me.moon.ticketReservation.supplier.dto.SupplierSaveRequestDto;
import me.moon.ticketReservation.supplier.dto.SupplierUpdateRequestDto;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.supplier.exception.DuplicateEmailException;
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

    public SupplierResponseDto update(String userId, SupplierUpdateRequestDto dto) {
        Supplier supplier = supplierMapper.findById(userId);
        supplier.update(dto);
        supplierMapper.update(supplier);
        return new SupplierResponseDto().of(supplier);
    }

    private boolean isDuplicateEmail(String email) {
        return supplierMapper.isDuplicateEmail(email);
    }


}
