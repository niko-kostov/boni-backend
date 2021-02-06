package com.project.boni.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemPriceNotFoundException extends RuntimeException{
    public ItemPriceNotFoundException(Long id){
        super(String.format("Item with Price with id %d not found", id));
    }
}