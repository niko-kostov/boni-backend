package com.project.boni.service.Impl;

import com.project.boni.model.ShoppingCart;
import com.project.boni.model.ShoppingCartItem;
import com.project.boni.repository.ItemRepository;
import com.project.boni.repository.ShoppingCartItemRepository;
import com.project.boni.service.ShoppingCartItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    public ShoppingCartItemServiceImpl(ShoppingCartItemRepository shoppingCartItemRepository) {
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    @Override
    public List<ShoppingCartItem> findAll() {
        return this.shoppingCartItemRepository.findAll();
    }

    @Override
    public ShoppingCartItem save(ShoppingCartItem shoppingCartItem) {
        return this.shoppingCartItemRepository.save(shoppingCartItem);
    }
}