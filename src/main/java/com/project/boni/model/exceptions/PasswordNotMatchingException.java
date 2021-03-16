package com.project.boni.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PasswordNotMatchingException extends RuntimeException{
    public PasswordNotMatchingException(String email){
        super(String.format("Incorrect old password for user: %s", email));
    }
}