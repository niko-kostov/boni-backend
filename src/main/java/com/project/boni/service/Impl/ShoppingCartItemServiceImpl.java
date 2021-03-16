package com.project.boni.service.Impl;

import com.project.boni.model.*;
import com.project.boni.model.dto.AddItemToCartDto;
import com.project.boni.model.dto.ChangeShoppingCartItemQuantityDto;
import com.project.boni.model.exceptions.ItemNotFoundException;
import com.project.boni.model.exceptions.ItemPriceNotFoundException;
import com.project.boni.model.exceptions.ShoppingCartItemNotFoundException;
import com.project.boni.model.exceptions.ShoppingCartNotFoundException;
import com.project.boni.repository.ItemRepository;
import com.project.boni.repository.ShoppingCartItemRepository;
import com.project.boni.repository.ShoppingCartRepository;
import com.project.boni.service.ShoppingCartItemService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartItemServiceImpl implements ShoppingCartItemService {
    private final ShoppingCartItemRepository shoppingCartItemRepository;
    private final ShoppingCartRepository shoppingCartRepository;
    private final ItemRepository itemRepository;

    public ShoppingCartItemServiceImpl(ShoppingCartItemRepository shoppingCartItemRepository, ShoppingCartRepository shoppingCartRepository, ItemRepository itemRepository) {
        this.shoppingCartItemRepository = shoppingCartItemRepository;
        this.shoppingCartRepository = shoppingCartRepository;
        this.itemRepository = itemRepository;
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
    public ShoppingCartItem changeQuantity(ChangeShoppingCartItemQuantityDto changeShoppingCartItemQuantityDto) {
        ShoppingCartItem shoppingCartItem = this.findById(changeShoppingCartItemQuantityDto.getShoppingCartId(), changeShoppingCartItemQuantityDto.getItemPriceId());
        shoppingCartItem.setQuantity(changeShoppingCartItemQuantityDto.getQuantity());
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

    @Override
    public ShoppingCartItem addItemToCart(AddItemToCartDto addItemToCartDto) {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        Item item = this.itemRepository.findById(addItemToCartDto.getItemId()).orElseThrow(() -> new ItemNotFoundException(addItemToCartDto.getItemId()));
        Optional<ItemPrice> itemPriceSent = item.getItemPrices().stream().filter(itemPrice -> itemPrice.getId().equals(addItemToCartDto.getItemPriceId())).findAny();
        if (itemPriceSent.isPresent()) {
            shoppingCartItem.setItemPrice(itemPriceSent.get());
        } else {
            throw new ItemPriceNotFoundException(addItemToCartDto.getItemPriceId());
        }

        ShoppingCart shoppingCart = this.shoppingCartRepository.findById(addItemToCartDto.getShoppingCartId())
                .orElseThrow(() ->new ShoppingCartNotFoundException(addItemToCartDto.getShoppingCartId()));

        shoppingCartItem.setShoppingCart(shoppingCart);
        shoppingCartItem.setId(new ShoppingCartItemKey(shoppingCart.getId(), addItemToCartDto.getItemPriceId()));
        shoppingCartItem.setQuantity(addItemToCartDto.getQuantity());
        return this.shoppingCartItemRepository.save(shoppingCartItem);
    }
}