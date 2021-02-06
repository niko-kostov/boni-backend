package com.project.boni.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class MenuNotExistException extends RuntimeException{
    public MenuNotExistException(){
        super("Currently there are no menus in the base!");
    }
}