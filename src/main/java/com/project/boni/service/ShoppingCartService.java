package com.project.boni.service;

import com.project.boni.model.ShoppingCart;

public interface ShoppingCartService {
    ShoppingCart findById(Long id);

    ShoppingCart save(ShoppingCart shoppingCart);

    ShoppingCart deleteById(Long id);

    ShoppingCart getActiveShoppingCart(String email);
}
