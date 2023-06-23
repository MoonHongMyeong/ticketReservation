package me.moon.ticketReservation.customer.repository;

import me.moon.ticketReservation.customer.entity.Customer;
import me.moon.ticketReservation.login.dto.LoginRequestDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
    void signUp(Customer customer);

    boolean isDuplicateEmail(String email);

    Customer findById(String customerId);

    void update(Customer customer);

    int deleteById(String customerId);

    Customer findByLoginRequest(LoginRequestDto dto);
}
