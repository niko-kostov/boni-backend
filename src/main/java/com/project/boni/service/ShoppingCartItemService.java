package com.project.boni.service;

import com.project.boni.model.ShoppingCartItem;
import com.project.boni.model.dto.AddItemToCartDto;
import com.project.boni.model.dto.IncreaseShoppingCartItemQuantityDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ShoppingCartItemService {

    List<ShoppingCartItem> findAll();

    ShoppingCartItem save(ShoppingCartItem shoppingCartItem);

    ShoppingCartItem increaseQuantity(IncreaseShoppingCartItemQuantityDto increaseShoppingCartItemQuantityDto);

    ShoppingCartItem findById(Long shoppingCartId, Long itemPriceId);

    ShoppingCartItem deleteItemFromCart(Long shoppingCartId, Long itemPriceId);

    ShoppingCartItem addItemToCart(AddItemToCartDto addItemToCartDto);
}
