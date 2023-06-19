package me.moon.ticketReservation.supplier.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class Supplier {
    private Long id;
    private String email;
    private String password;
    private String name;
    private String companyName;
    private String businessRegNo;
    private String phone;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Role role;

    @Builder
    public Supplier(String email, String password, String name, String companyName, String businessRegNo, String phone, Role role){
        this.email = email;
        this.password = password;
        this.name = name;
        this.companyName = companyName;
        this.businessRegNo = businessRegNo;
        this.phone = phone;
        this.role = role;
    }

    public Supplier updatePassword(String password){
        this.password = password;
        return this;
    }
}
