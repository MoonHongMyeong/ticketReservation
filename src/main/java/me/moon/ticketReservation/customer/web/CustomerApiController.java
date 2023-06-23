package me.moon.ticketReservation.customer.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.customer.dto.CustomerResponseDto;
import me.moon.ticketReservation.customer.dto.CustomerSaveRequestDto;
import me.moon.ticketReservation.customer.dto.CustomerUpdateRequestDto;
import me.moon.ticketReservation.customer.service.CustomerService;
import me.moon.ticketReservation.login.annotation.LoginRequired;
import me.moon.ticketReservation.login.annotation.LoginUser;
import me.moon.ticketReservation.login.entity.SessionUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class CustomerApiController {
    private final CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<CustomerResponseDto> signUp(@RequestBody CustomerSaveRequestDto dto){
        CustomerResponseDto response = customerService.signUp(dto);
        return ResponseEntity.ok(response);
    }

    @LoginRequired
    @PutMapping("/customer/{customerId}")
    public ResponseEntity<CustomerResponseDto> updateCustomerInfo(@LoginUser SessionUser sessionUser, @RequestBody CustomerUpdateRequestDto dto, @PathVariable(value = "customerId") String customerId){
        CustomerResponseDto response = customerService.update(sessionUser, customerId, dto);
        return ResponseEntity.ok(response);
    }

    @LoginRequired
    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<String> withdrawal(@LoginUser SessionUser sessionUser, @PathVariable(value = "customerId") String customerId){
        customerService.delete(sessionUser, customerId);
        return ResponseEntity.ok("회원탈퇴 성공!");
    }
}
