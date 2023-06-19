package me.moon.ticketReservation.supplier.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.supplier.entity.Role;
import me.moon.ticketReservation.supplier.entity.Supplier;

@Getter
@NoArgsConstructor
public class SupplierResponseDto {
    private String email;
    private String name;
    private String companyName;
    private Role role;

    @Builder
    public SupplierResponseDto(String email, String name, String companyName, Role role){
        this.email = email;
        this.name = name;
        this.companyName = companyName;
        this.role = role;
    }

    public static SupplierResponseDto of(Supplier supplier){
        return SupplierResponseDto.builder()
                .email(supplier.getEmail())
                .name(supplier.getName())
                .companyName(supplier.getCompanyName())
                .role(supplier.getRole())
                .build();
    }

}
