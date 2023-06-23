package me.moon.ticketReservation.supplier.repository;

import me.moon.ticketReservation.login.dto.LoginRequestDto;
import me.moon.ticketReservation.supplier.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplierMapper {
    void signUp(Supplier supplier);
    boolean isDuplicateEmail(String email);

    Supplier findById(String supplierId);

    void update(Supplier supplier);

    int deleteById(String supplierId);

    Supplier findByLoginRequest(LoginRequestDto dto);
}
