package me.moon.ticketReservation.customer.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.customer.dto.CustomerResponseDto;
import me.moon.ticketReservation.customer.dto.CustomerSaveRequestDto;
import me.moon.ticketReservation.customer.dto.CustomerUpdateRequestDto;
import me.moon.ticketReservation.customer.service.CustomerService;
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

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<CustomerResponseDto> updateCustomerInfo(@RequestBody CustomerUpdateRequestDto dto, @PathVariable(value = "customerId") String customerId){
        CustomerResponseDto response = customerService.update(customerId, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<String> withdrawal(@PathVariable(value = "customerId") String customerId){
        customerService.delete(customerId);
        return ResponseEntity.ok("회원탈퇴 성공!");
    }
}
