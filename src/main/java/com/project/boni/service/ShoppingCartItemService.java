package com.project.boni.service;

import com.project.boni.model.ShoppingCartItem;
import com.project.boni.model.dto.AddItemToCartDto;
import com.project.boni.model.dto.ChangeShoppingCartItemQuantityDto;

import java.util.List;

public interface ShoppingCartItemService {

    List<ShoppingCartItem> findAll();

    ShoppingCartItem save(ShoppingCartItem shoppingCartItem);

    ShoppingCartItem changeQuantity(ChangeShoppingCartItemQuantityDto changeShoppingCartItemQuantityDto);

    ShoppingCartItem findById(Long shoppingCartId, Long itemPriceId);

    ShoppingCartItem deleteItemFromCart(Long shoppingCartId, Long itemPriceId);

    ShoppingCartItem addItemToCart(AddItemToCartDto addItemToCartDto);
}
