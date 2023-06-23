package me.moon.ticketReservation.login.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.moon.ticketReservation.customer.entity.Customer;
import me.moon.ticketReservation.supplier.entity.Supplier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;

@Getter
@NoArgsConstructor
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String name;
    private String role;

    public SessionUser(Supplier supplier){
        this.id = supplier.getId();
        this.email = supplier.getEmail();
        this.name = supplier.getName();
        this.role = supplier.getRole().name();
    }

    public SessionUser(Customer customer){
        this.id = customer.getId();
        this.email = customer.getEmail();
        this.name = customer.getName();
        this.role = "CUSTOMER";
    }
}
