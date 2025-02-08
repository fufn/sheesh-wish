package kz.wishify.controller;

import kz.wishify.exception.ErrorResponse;
import kz.wishify.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<kz.wishify.exception.ErrorResponse> handleServiceException(final ServiceException e) {
        var errorResponse = new ErrorResponse(e.getExceptionType().name(), e.getMessage());
        return new ResponseEntity<>(errorResponse, e.getExceptionType().getStatusCode());
    }
}
