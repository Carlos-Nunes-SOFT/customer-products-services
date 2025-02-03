package com.bankinter.services.sso.customer_products_and_services.ambar.application.exceptions;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class GenericErrorResponse {
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public GenericErrorResponse(String message, String details, LocalDateTime timestamp) {
        this.message = message;
        this.details = details;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setStatus(String details) {
        this.details = details;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

