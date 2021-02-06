package com.project.boni.service;

import com.project.boni.model.ShoppingCart;
import com.project.boni.model.ShoppingCartItem;

import java.util.List;

public interface ShoppingCartItemService {

    List<ShoppingCartItem> findAll();

    ShoppingCartItem deleteByItemPriceId(Long id);

    ShoppingCartItem save(ShoppingCartItem shoppingCartItem);

    List<ShoppingCartItem> listAllItemsInShoppingCart(Long cartId);

    ShoppingCart addItemToShoppingCart(Long cartId, Long itemId);
}
