package com.aa.aainventorysystembe.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ResourceNotFoundException extends RuntimeException {
    private String errorCode;

    public ResourceNotFoundException(String errorCode, String message){
        super(message);
        this.errorCode = errorCode;
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public String getErrorCode() {
        return errorCode;
    }
}
