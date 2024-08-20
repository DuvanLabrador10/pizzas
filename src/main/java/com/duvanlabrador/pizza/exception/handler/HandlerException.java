package com.duvanlabrador.pizza.exception.handler;

import com.duvanlabrador.pizza.exception.ResourceNotFoundException;
import com.duvanlabrador.pizza.persistence.dto.ErrorDetail;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
@AllArgsConstructor
public class HandlerException {

    private final ErrorDetail errorDetail;

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> resourceNotFound(ResourceNotFoundException ex){
        errorDetail.setDateTime(new Date());
        errorDetail.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetail.setTitle("Resource Not Found");
        errorDetail.setDetail(ex.getMessage());
        errorDetail.setDeveloperMessage(ex.getClass().getName());
        return new ResponseEntity<>(errorDetail,null,HttpStatus.NOT_FOUND);
    }
}
