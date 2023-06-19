package me.moon.ticketReservation.customer.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.customer.dto.CustomerResponseDto;
import me.moon.ticketReservation.customer.dto.CustomerSaveRequestDto;
import me.moon.ticketReservation.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
