package me.moon.ticketReservation.supplier.web;

import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.login.annotation.LoginRequired;
import me.moon.ticketReservation.login.annotation.LoginUser;
import me.moon.ticketReservation.login.entity.SessionUser;
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

    @PostMapping("/supplier")
    public ResponseEntity<SupplierResponseDto> signUp(@RequestBody SupplierSaveRequestDto dto){
        SupplierResponseDto response = supplierService.signUp(dto);
        return ResponseEntity.ok(response);
    }

    @LoginRequired
    @PutMapping("/supplier/{supplierId}")
    public ResponseEntity<SupplierResponseDto> updateSupplierInfo(@LoginUser SessionUser sessionUser, @RequestBody SupplierUpdateRequestDto dto, @PathVariable(value = "supplierId") String supplierId){
        SupplierResponseDto response = supplierService.update(sessionUser, supplierId, dto);
        return ResponseEntity.ok(response);
    }

    @LoginRequired
    @DeleteMapping("/supplier/{supplierId}")
    public ResponseEntity<String> withdrawal(@LoginUser SessionUser sessionUser, @PathVariable(value = "supplierId") String supplierId){
        supplierService.delete(sessionUser, supplierId);
        return ResponseEntity.ok("회원탈퇴 되었습니다.");
    }
}
