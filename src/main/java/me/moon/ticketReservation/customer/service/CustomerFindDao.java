package me.moon.ticketReservation.customer.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.customer.entity.Customer;
import me.moon.ticketReservation.customer.repository.CustomerMapper;
import me.moon.ticketReservation.login.dto.LoginRequestDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerFindDao {
    private final CustomerMapper customerMapper;

    public Customer findByLoginRequest(LoginRequestDto dto){
        return customerMapper.findByLoginRequest(dto);
    }
}
