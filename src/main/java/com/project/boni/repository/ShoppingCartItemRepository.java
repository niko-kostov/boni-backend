package com.project.boni.repository;

import com.project.boni.model.ShoppingCartItem;
import com.project.boni.model.ShoppingCartItemKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, ShoppingCartItemKey> {
    List<ShoppingCartItem> findByIdShoppingCartId(Long shoppingCartId);

    List<ShoppingCartItem> findByIdItemPriceId(Long itemPriceId);
}