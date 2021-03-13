package com.project.boni.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotBlank;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserNotActiveException extends RuntimeException {
    public UserNotActiveException(@NotBlank String email) {
        super(String.format("User with email %s is not active", email));
    }
}
