package me.moon.ticketReservation.customer.service;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.common.exception.ErrorCode;
import me.moon.ticketReservation.customer.dto.CustomerResponseDto;
import me.moon.ticketReservation.customer.dto.CustomerSaveRequestDto;
import me.moon.ticketReservation.customer.dto.CustomerUpdateRequestDto;
import me.moon.ticketReservation.customer.entity.Customer;
import me.moon.ticketReservation.customer.repository.CustomerMapper;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.login.exception.UnauthorizedAccessException;
import me.moon.ticketReservation.supplier.exception.DuplicateEmailException;
import me.moon.ticketReservation.supplier.exception.WithdrawalException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerMapper customerMapper;


    public CustomerResponseDto signUp(CustomerSaveRequestDto dto) {
        if ( isDuplicateEmail(dto.getEmail()) ) {
            throw new DuplicateEmailException(dto.getEmail());
        }
        Customer customer = dto.toEntity();
        customerMapper.signUp(customer);

        return CustomerResponseDto.of(customer);
    }

    private boolean isDuplicateEmail(String email) {
        return customerMapper.isDuplicateEmail(email);
    }

    public CustomerResponseDto update(SessionUser sessionUser, String customerId, CustomerUpdateRequestDto dto) {
        Customer customer = customerMapper.findById(customerId);
        if ( !compareUserAndSessionUser(sessionUser, customer) ) {
            throw new UnauthorizedAccessException(sessionUser.getEmail(), ErrorCode.UNAUTHORIZED_ACCESS);
        }
        customer.update(dto);
        customerMapper.update(customer);
        return CustomerResponseDto.of(customer);
    }

    private boolean compareUserAndSessionUser(SessionUser sessionUser, Customer customer) {
        return sessionUser.getEmail().equals(customer.getEmail());
    }

    public void delete(SessionUser sessionUser, String customerId) {
        Customer customer = customerMapper.findById(customerId);
        if ( !compareUserAndSessionUser(sessionUser, customer) ) {
            throw new UnauthorizedAccessException(sessionUser.getEmail(), ErrorCode.UNAUTHORIZED_ACCESS);
        }
        int result = customerMapper.deleteById(customerId);
        if ( result != 1 ) {
            throw new WithdrawalException(customerId);
        }
    }
}
