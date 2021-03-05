package com.project.boni.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShoppingCartStillActiveException extends RuntimeException{
    public ShoppingCartStillActiveException(Long id){
        super(String.format("Shopping cart with id %d is still active", id));
    }
}