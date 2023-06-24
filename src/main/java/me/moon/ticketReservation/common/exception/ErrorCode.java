package me.moon.ticketReservation.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "C500", "알수없는 에러 관리자에게 문의하세요."),
    INVALID_INPUT_VALUE(400, "C400", "잘못된 입력 값 입니다."),
    METHOD_NOT_ALLOWED(405, "C405", "사용할 수 없는 요청입니다."),
    ACCESS_DENIED(403, "C403", "잘못된 접근입니다."),
    DUPLICATE_EMAIL(409, "C409", "이미 가입된 회원입니다."),
    WITHDRAWAL(409, "C410", "회원탈퇴 문제가 발생했습니다."),
    WRONG_LOGIN_REQUEST(403, "C413", "잘못된 로그인 요청입니다."),
    WRONG_LOGIN_INPUT(403, "C423", "이메일 혹은 비밀번호가 잘못되었습니다."),
    LOGIN_REQUIRED(401, "C401", "로그인이 필요한 요청입니다."),
    UNAUTHORIZED_ACCESS(403, "C433", "허가되지 않은 접근입니다."),
    WRONG_USER_ROLE(403, "C443", "권한이 없는 요청입니다.\n권한을 확인해주세요."),
    DUPLICATE_VENUES(409, "C479", "중복된 공연장입니다."),
    VENUS_NOT_FOUND(400, "C410", "해당 공연장을 찾을 수 없습니다."),
    DUPLICATE_PERFORMANCE(409, "C489", "중복 공연 입니다.");

    private int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
