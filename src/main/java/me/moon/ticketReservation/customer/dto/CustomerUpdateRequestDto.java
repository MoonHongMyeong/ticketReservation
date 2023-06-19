package me.moon.ticketReservation.customer.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CustomerUpdateRequestDto {
    private String name;
    private String phone;

    @Builder
    public CustomerUpdateRequestDto(String name, String phone){
        this.name = name;
        this.phone = phone;
    }
}
