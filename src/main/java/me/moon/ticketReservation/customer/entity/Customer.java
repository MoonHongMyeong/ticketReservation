package me.moon.ticketReservation.customer.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class Customer {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String phone;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @Builder
    public Customer(String email, String password, String name, String phone){
        this.email = email;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }
}
