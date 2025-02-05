package com.bankinter.services.sso.customer_products_and_services.ambar.application.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED)
public class DuplicatedException extends RuntimeException{
    public DuplicatedException(String message){
        super(message);
    }
}
