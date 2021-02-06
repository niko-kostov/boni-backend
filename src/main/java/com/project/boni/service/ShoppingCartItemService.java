package com.project.boni.service;

import com.project.boni.model.ShoppingCart;
import com.project.boni.model.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartItemService {

    List<ShoppingCartItem> findAll();

    ShoppingCartItem save(ShoppingCartItem shoppingCartItem);
}
