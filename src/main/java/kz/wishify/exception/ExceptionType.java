package kz.wishify.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ExceptionType {

    WISH_NOT_FOUND(HttpStatus.NOT_FOUND, "Wish not found");

    private final HttpStatus statusCode;
    private final String message;
}
