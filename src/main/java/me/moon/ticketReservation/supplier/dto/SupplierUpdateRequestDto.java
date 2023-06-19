package me.moon.ticketReservation.supplier.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SupplierUpdateRequestDto {
    private String name;
    private String companyName;
    private String businessRegNo;
    private String phone;

    @Builder
    public SupplierUpdateRequestDto(String name, String companyName, String businessRegNo, String phone){
        this.name = name;
        this.companyName = companyName;
        this.businessRegNo = businessRegNo;
        this.phone = phone;
    }
}
