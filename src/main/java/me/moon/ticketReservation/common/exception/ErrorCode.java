package me.moon.ticketReservation.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INTERNAL_SERVER_ERROR(500, "C500", "알수없는 에러 관리자에게 문의하세요."),
    INVALID_INPUT_VALUE(400, "C400", "잘못된 입력 값 입니다."),
    METHOD_NOT_ALLOWED(405, "C405", "사용할 수 없는 요청입니다."),
    ACCESS_DENIED(403, "C403", "잘못된 접근입니다."),
    DUPLICATE_EMAIL(409, "C409", "이미 가입된 회원입니다."),
    WITHDRAWAL(409, "C410", "회원탈퇴 문제가 발생했습니다.");

    private int status;
    private final String code;
    private final String message;

    ErrorCode(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
