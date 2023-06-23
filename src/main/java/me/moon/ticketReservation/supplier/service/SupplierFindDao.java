package me.moon.ticketReservation.supplier.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.login.dto.LoginRequestDto;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.supplier.repository.SupplierMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierFindDao {
    private final SupplierMapper supplierMapper;

    public Supplier findByLoginRequest(LoginRequestDto dto) {
        return supplierMapper.findByLoginRequest(dto);
    }

    public Supplier findById(String id) {
        return supplierMapper.findById(id);
    }
}
