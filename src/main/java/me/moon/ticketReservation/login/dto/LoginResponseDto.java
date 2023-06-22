package me.moon.ticketReservation.login.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.customer.entity.Customer;
import me.moon.ticketReservation.supplier.entity.Role;
import me.moon.ticketReservation.supplier.entity.Supplier;

@Getter
@NoArgsConstructor
public class LoginResponseDto {
    private String name;
    private String email;
    private String role;

    @Builder
    public LoginResponseDto(String name, String email, String role){
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public static LoginResponseDto of(Supplier supplier){
        return LoginResponseDto.builder()
                .name(supplier.getName())
                .email(supplier.getEmail())
                .role(supplier.getRole().name())
                .build();
    }

    public static LoginResponseDto of(Customer customer){
        return LoginResponseDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .role("CUSTOMER")
                .build();
    }
}
