package com.project.boni.service.Impl;

import com.project.boni.model.ShoppingCartItem;
import com.project.boni.model.ShoppingCartItemKey;
import com.project.boni.model.dto.IncreaseShoppingCartItemQuantityDto;
import com.project.boni.model.exceptions.ShoppingCartItemNotFoundException;
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

    @Override
    public ShoppingCartItem increaseQuantity(IncreaseShoppingCartItemQuantityDto increaseShoppingCartItemQuantityDto) {
        ShoppingCartItem shoppingCartItem = this.findById(increaseShoppingCartItemQuantityDto.getShoppingCartId(), increaseShoppingCartItemQuantityDto.getItemPriceId());
        shoppingCartItem.setQuantity(increaseShoppingCartItemQuantityDto.getQuantity());
        return this.shoppingCartItemRepository.save(shoppingCartItem);
    }

    @Override
    public ShoppingCartItem findById(Long shoppingCartId, Long itemPriceId) {
        return this.shoppingCartItemRepository.findById(new ShoppingCartItemKey(shoppingCartId, itemPriceId))
                .orElseThrow(() -> new ShoppingCartItemNotFoundException(shoppingCartId, itemPriceId));
    }

    @Override
    public ShoppingCartItem deleteItemFromCart(Long shoppingCartId, Long itemPriceId) {
        ShoppingCartItem deletedShoppingCartItem = this.findById(shoppingCartId, itemPriceId);
        this.shoppingCartItemRepository.delete(deletedShoppingCartItem);
        return deletedShoppingCartItem;
    }
}