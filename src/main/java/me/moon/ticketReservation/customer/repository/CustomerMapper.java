package me.moon.ticketReservation.customer.repository;

import me.moon.ticketReservation.customer.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    void signUp(Customer customer);

    boolean isDuplicateEmail(String email);
}
