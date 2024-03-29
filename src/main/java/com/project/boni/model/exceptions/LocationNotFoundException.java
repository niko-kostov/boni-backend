package com.project.boni.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LocationNotFoundException extends RuntimeException{
    public LocationNotFoundException(Long id){
        super(String.format("Location with id %d not found", id));
    }
}