package com.project.boni.service;

import com.project.boni.model.ShoppingCart;
import com.project.boni.model.ShoppingCartItem;
import com.project.boni.model.dto.*;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart findById(Long id);

    ShoppingCart save(ShoppingCart shoppingCart);

    ShoppingCart deleteById(Long id);

    GetShoppingCartDto getActiveShoppingCart(String email);

    ShoppingCart createShoppingCartForUser(String email);

    ShoppingCartItem addItemToCart(AddItemToCartDto addItemToCartDto);

    ShoppingCart payShoppingCart(PayShoppingCartDto payShoppingCartDto);

    List<GetOrderHistoryDto> getOrderHistoryForUser(String email);

    List<GetOrderHistoryDetailsDto> getOrderHistoryDetails(Long id);
}