package me.moon.ticketReservation.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import me.moon.ticketReservation.common.exception.ErrorCode;
import me.moon.ticketReservation.login.annotation.LoginRequired;
import me.moon.ticketReservation.login.entity.SessionUser;
import me.moon.ticketReservation.login.exception.LoginRequiredException;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final String USER = "USER";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler){
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        SessionUser sessionUser = (SessionUser) request.getSession().getAttribute(USER);

        if ( handlerMethod.hasMethodAnnotation(LoginRequired.class) && sessionUser == null ){
            throw new LoginRequiredException(ErrorCode.LOGIN_REQUIRED);
        }

        return true;
    }
}
