package com.duvanlabrador.pizza.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ResourceForbidden extends RuntimeException{
    public ResourceForbidden(String message){
        super(message);
    }
}
