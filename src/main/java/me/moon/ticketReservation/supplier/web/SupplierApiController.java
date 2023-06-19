package me.moon.ticketReservation.supplier.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.supplier.dto.SupplierResponseDto;
import me.moon.ticketReservation.supplier.dto.SupplierSaveRequestDto;
import me.moon.ticketReservation.supplier.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SupplierApiController {
    private final SupplierService supplierService;

    @PostMapping("/users")
    public ResponseEntity<SupplierResponseDto> signUp(@RequestBody SupplierSaveRequestDto dto){
        SupplierResponseDto response = supplierService.signUp(dto);
        return ResponseEntity.ok(response);
    }
}
