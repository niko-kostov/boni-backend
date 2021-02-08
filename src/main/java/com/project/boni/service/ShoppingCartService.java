package com.project.boni.service;

import com.project.boni.model.ShoppingCart;
import com.project.boni.model.dto.GetShoppingCartDto;

public interface ShoppingCartService {
    ShoppingCart findById(Long id);

    ShoppingCart save(ShoppingCart shoppingCart);

    ShoppingCart deleteById(Long id);

    GetShoppingCartDto getActiveShoppingCart(String email);

    ShoppingCart createShoppingCartForUser(String email);
}
