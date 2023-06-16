package me.moon.ticketReservation.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {
    private String message;
    private String code;
    private int status;
    private List<FieldError> errors = new ArrayList();

    private ErrorResponse(final ErrorCode errorCode){
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
        this.status = errorCode.getStatus();
        this.errors = new ArrayList<>();
    }

    private ErrorResponse(final ErrorCode errorCode, final List<FieldError> errors){
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
        this.status = errorCode.getStatus();
        this.errors = errors;
    }

    public static ErrorResponse of(final ErrorCode errorCode){
        return new ErrorResponse(errorCode);
    }

    public static ErrorResponse of(final ErrorCode errorCode, final List<FieldError> errors){
        return new ErrorResponse(errorCode, errors);
    }

    public static ErrorResponse of(final ErrorCode errorCode, final BindingResult bindingResult){
        return new ErrorResponse(errorCode, FieldError.of(bindingResult));
    }

    public static ErrorResponse of(MethodArgumentTypeMismatchException exception){
        final String value = exception.getValue() == null ? "" : exception.getValue().toString();
        final List<FieldError> fieldErrors = ErrorResponse.FieldError.of(exception.getName(), value, exception.getErrorCode());
        return new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR, fieldErrors);
    }


    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class FieldError{
        private String field;
        private String value;
        private String reason;

        private FieldError(final String field, final String value, final String reason){
            this.field = field;
            this.value = value;
            this.reason = reason;
        }

        private static List<FieldError> of(final String field, final String value, final String reason){
            List<FieldError> fieldErrors = new ArrayList<>();
            fieldErrors.add(new FieldError(field, value, reason));
            return fieldErrors;
        }

        private static List<FieldError> of(final BindingResult bindingResult){
            final List<org.springframework.validation.FieldError> fieldErrors = bindingResult.getFieldErrors();
            return fieldErrors.stream()
                    .map(error -> new FieldError(
                            error.getField(),
                            error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                            error.getDefaultMessage()))
                    .collect(Collectors.toList());
        }


    }
}
