package me.moon.ticketReservation.login.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import me.moon.ticketReservation.customer.entity.Customer;
import me.moon.ticketReservation.customer.service.CustomerFindDao;
import me.moon.ticketReservation.login.dto.LoginRequestDto;
import me.moon.ticketReservation.login.dto.LoginResponseDto;
import me.moon.ticketReservation.login.exception.WrongLoginException;
import me.moon.ticketReservation.common.exception.ErrorCode;
import me.moon.ticketReservation.login.exception.WrongUserRoleException;
import me.moon.ticketReservation.supplier.entity.Supplier;
import me.moon.ticketReservation.supplier.service.SupplierFindDao;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SessionLoginService implements LoginService{
    private final HttpSession session;
    private final CustomerFindDao customerFindDao;
    private final SupplierFindDao supplierFindDao;
    private static final String USER = "USER";
    @Override
    public LoginResponseDto login(String userRole, LoginRequestDto dto) {
        if ( userRole.equals("customer")){
            Customer customer = customerFindDao.findByLoginRequest(dto);
            if ( customer == null ){
                throw new WrongLoginException(dto.getEmail(), ErrorCode.WRONG_LOGIN_INPUT);
            }
            LoginResponseDto response = LoginResponseDto.of(customer);
            session.setAttribute(USER, response);
            return response;
        }else if ( userRole.equals("supplier")) {
            Supplier supplier = supplierFindDao.findByLoginRequest(dto);
            if ( supplier == null ) {
                throw new WrongLoginException(dto.getEmail(), ErrorCode.WRONG_LOGIN_INPUT);
            }
            LoginResponseDto response = LoginResponseDto.of(supplier);
            session.setAttribute(USER, response);
            return response;
        }else{
            throw new WrongUserRoleException(userRole, ErrorCode.WRONG_LOGIN_REQUEST);
        }
    }

    @Override
    public void logout() {
        session.invalidate();
    }
}
