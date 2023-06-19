package me.moon.ticketReservation.customer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.customer.entity.Customer;

@Getter
@NoArgsConstructor
public class CustomerSaveRequestDto {
    private String email;
    private String password;
    private String name;
    private String phone;

    @Builder
    public CustomerSaveRequestDto(String email, String password, String name, String phone){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public Customer toEntity(){
        return Customer.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .phone(this.phone)
                .build();
    }
}
