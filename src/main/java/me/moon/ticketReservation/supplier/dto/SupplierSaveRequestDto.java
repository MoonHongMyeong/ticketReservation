package me.moon.ticketReservation.supplier.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.supplier.entity.Role;
import me.moon.ticketReservation.supplier.entity.Supplier;

@Getter
@NoArgsConstructor
public class SupplierSaveRequestDto {
    private String email;
    private String password;
    private String name;
    private String companyName;
    private String businessRegNo;
    private String phone;
    private String role;

    @Builder
    public SupplierSaveRequestDto(String email, String password, String name, String companyName, String businessRegNo, String phone, String role){
        this.email = email;
        this.password = password;
        this.name = name;
        this.companyName = companyName;
        this.businessRegNo = businessRegNo;
        this.phone = phone;
        this.role = role;
    }

    public Supplier toEntity(){
        return Supplier.builder()
                .email(this.email)
                .password(this.password)
                .name(this.name)
                .companyName(this.companyName)
                .businessRegNo(this.businessRegNo)
                .phone(this.phone)
                .role(Role.valueOf(this.role))
                .build();
    }
}
