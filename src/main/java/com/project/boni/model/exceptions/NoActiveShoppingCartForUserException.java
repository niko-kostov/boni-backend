package com.project.boni.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoActiveShoppingCartForUserException extends RuntimeException{
    public NoActiveShoppingCartForUserException(String email){
        super(String.format("User with email: %s does not have active shopping cart", email));
    }
}