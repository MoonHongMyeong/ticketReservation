package me.moon.ticketReservation.supplier.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.supplier.dto.SupplierResponseDto;
import me.moon.ticketReservation.supplier.dto.SupplierSaveRequestDto;
import me.moon.ticketReservation.supplier.dto.SupplierUpdateRequestDto;
import me.moon.ticketReservation.supplier.service.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/users/{userId}")
    public ResponseEntity<SupplierResponseDto> updateSupplierInfo(@RequestBody SupplierUpdateRequestDto dto, @PathVariable(value = "userId") String userId){
        SupplierResponseDto response = supplierService.update(userId, dto);
        return ResponseEntity.ok(response);
    }
}
