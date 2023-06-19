package me.moon.ticketReservation.customer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.customer.entity.Customer;

@Getter
@NoArgsConstructor
public class CustomerResponseDto {
    private String email;
    private String name;
    private String phone;

    @Builder
    public CustomerResponseDto(String email, String name, String phone){
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public static CustomerResponseDto of(Customer customer){
        return CustomerResponseDto.builder()
                .email(customer.getEmail())
                .name(customer.getName())
                .phone(customer.getPhone())
                .build();
    }
}
