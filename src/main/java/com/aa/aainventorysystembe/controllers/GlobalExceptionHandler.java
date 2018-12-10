package com.aa.aainventorysystembe.controllers;

import com.aa.aainventorysystembe.exception.ResourceNotFoundException;
import com.aa.aainventorysystembe.models.ErrorCode;
import com.aa.aainventorysystembe.models.Response;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.xml.bind.ValidationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public Response resourceNotFoundException(ResourceNotFoundException ex){
        return Response.builder()
                .code(ex.getErrorCode())
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(value = ValidationException.class)
    public Response validationException(ValidationException ex){
        return Response.builder()
                .code(ErrorCode.BAD_REQUEST.getCode())
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response methodArgumentNotValidException(MethodArgumentNotValidException ex){
        return Response.builder()
                .code(ErrorCode.BAD_REQUEST.getCode())
                .message(ex.getMessage())
                .build();
    }

    @ExceptionHandler(value = Exception.class)
    public Response exception(){
        return Response.builder()
                .code(ErrorCode.INTERNAL_SERVER_ERROR.getCode())
                .message(ErrorCode.INTERNAL_SERVER_ERROR.getMessage())
                .build();
    }

}
