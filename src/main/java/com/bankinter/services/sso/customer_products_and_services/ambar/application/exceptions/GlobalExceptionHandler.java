package com.bankinter.services.sso.customer_products_and_services.ambar.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InternalServerErrorException.class)
    public final ResponseEntity<GenericErrorResponse> handleInternalServerErrorException(
            Exception ex, WebRequest request) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(ex.getMessage(),
                request.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<GenericErrorResponse>(genericErrorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<GenericErrorResponse> handleNotFoundException(
            Exception ex, WebRequest request) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(ex.getMessage(),
                request.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<GenericErrorResponse>(genericErrorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<GenericErrorResponse> handleBadRequestException(
            Exception ex, WebRequest request) {
        GenericErrorResponse genericErrorResponse = new GenericErrorResponse(ex.getMessage(),
                request.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<GenericErrorResponse>(genericErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
