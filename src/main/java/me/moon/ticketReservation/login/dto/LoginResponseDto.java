package me.moon.ticketReservation.login.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.customer.entity.Customer;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.supplier.entity.Role;
import me.moon.ticketReservation.supplier.entity.Supplier;

@Getter
@NoArgsConstructor
public class LoginResponseDto {
    private Long id;
    private String name;
    private String email;
    private String role;

    @Builder
    public LoginResponseDto(Long id, String name, String email, String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public static LoginResponseDto of(SessionUser sessionUser){
        return LoginResponseDto.builder()
                .id(sessionUser.getId())
                .name(sessionUser.getName())
                .email(sessionUser.getEmail())
                .role(sessionUser.getRole())
                .build();
    }
}
