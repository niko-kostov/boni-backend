package com.project.boni.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ShoppingCartItemNotFoundException extends RuntimeException{
    public ShoppingCartItemNotFoundException(Long shoppingCartId, Long itemPriceId){
        super(String.format("Shopping cart with id: %d or Shopping Cart Item with id: %d does not exist!", shoppingCartId, itemPriceId));
    }
}