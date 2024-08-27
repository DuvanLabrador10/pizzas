package com.duvanlabrador.pizza.exception.handler;

import com.duvanlabrador.pizza.exception.ResourceBadRequestException;
import com.duvanlabrador.pizza.exception.ResourceForbidden;
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

    @ExceptionHandler(ResourceBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> resourceBadRequestException(ResourceBadRequestException ex){
        errorDetail.setDateTime(new Date());
        errorDetail.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetail.setTitle("BadRequest Exception");
        errorDetail.setDetail(ex.getMessage());
        errorDetail.setDeveloperMessage(ex.getClass().getName());
        return new ResponseEntity<>(errorDetail,null,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceForbidden.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<?> resourceForbidden(ResourceForbidden ex){
        errorDetail.setDateTime(new Date());
        errorDetail.setStatus(HttpStatus.FORBIDDEN.value());
        errorDetail.setTitle("Forbidden Exception");
        errorDetail.setDetail(ex.getMessage());
        errorDetail.setDeveloperMessage(ex.getClass().getName());
        return new ResponseEntity<>(errorDetail,null,HttpStatus.FORBIDDEN);
    }
}
