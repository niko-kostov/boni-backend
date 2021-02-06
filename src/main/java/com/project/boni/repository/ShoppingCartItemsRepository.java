package com.project.boni.repository;

import com.project.boni.model.ShoppingCartItems;
import com.project.boni.model.ShoppingCartItemsKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.cdi.JpaRepositoryExtension;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartItemsRepository extends JpaRepository<ShoppingCartItems, ShoppingCartItemsKey> {
    List<ShoppingCartItems> findByIdShoppingCartId(Long shoppingCartId);

    List<ShoppingCartItems> findByIdItemPriceId(Long itemPriceId);
}
