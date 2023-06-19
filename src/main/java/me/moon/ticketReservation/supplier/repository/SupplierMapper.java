package me.moon.ticketReservation.supplier.repository;

import me.moon.ticketReservation.supplier.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SupplierMapper {
    void signUp(Supplier supplier);
    boolean isDuplicateEmail(String email);
}
