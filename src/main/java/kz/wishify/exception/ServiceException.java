package kz.wishify.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceException extends RuntimeException {

    private ExceptionType exceptionType;
    private String message;

    public ServiceException(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
        this.message = exceptionType.getMessage();
    }

    public ServiceException(ExceptionType exceptionType, String message) {
        this.exceptionType = exceptionType;
        this.message = message;
    }
}
