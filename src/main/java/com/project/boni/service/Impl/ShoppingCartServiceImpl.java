package com.project.boni.service.Impl;

import com.project.boni.model.*;
import com.project.boni.model.baseClass.BaseTimeAuditedEntity;
import com.project.boni.model.dto.AddItemToCartDto;
import com.project.boni.model.dto.GetShoppingCartDto;
import com.project.boni.model.dto.PayShoppingCartDto;
import com.project.boni.model.enums.ShoppingCartStatus;
import com.project.boni.model.exceptions.ItemNotFoundException;
import com.project.boni.model.exceptions.ItemPriceNotFoundException;
import com.project.boni.model.exceptions.ShoppingCartNotFoundException;
import com.project.boni.model.exceptions.UserNotFoundException;
import com.project.boni.repository.*;
import com.project.boni.service.ShoppingCartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, ItemRepository itemRepository, ShoppingCartItemRepository shoppingCartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    @Override
    public ShoppingCart findById(Long id) {
        return this.shoppingCartRepository.findById(id).orElseThrow(() -> new ShoppingCartNotFoundException(id));
    }

    @Override
    public ShoppingCart save(ShoppingCart shoppingCart) {
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart deleteById(Long id) {
        ShoppingCart deletedCart = this.shoppingCartRepository.findById(id).orElseThrow(() -> new ShoppingCartNotFoundException(id));
        this.shoppingCartItemRepository.deleteAll(deletedCart.getShoppingCartItems());
        this.shoppingCartRepository.deleteById(id);
        return deletedCart;
    }

    @Override
    public GetShoppingCartDto getActiveShoppingCart(String email) {
        User user = this.userRepository.findById(email).orElseThrow(() -> new UserNotFoundException(email));
        Optional<ShoppingCart> findShoppingCartForUser = this.shoppingCartRepository.findAll()
                .stream().filter(shoppingCart -> shoppingCart.getUser().getEmail().equals(user.getEmail()) && shoppingCart.getStatus().equals(ShoppingCartStatus.CREATED)).findAny();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(ShoppingCart.class, GetShoppingCartDto.class).addMappings(mapper -> {
            mapper.map(BaseTimeAuditedEntity::getId, GetShoppingCartDto::setShoppingCartId);
            mapper.map(ShoppingCart::getShoppingCartItems, GetShoppingCartDto::setShoppingCartItemDtoList);
        });

        // map to GetShoppingCartDto
        if (findShoppingCartForUser.isEmpty()) {
            ShoppingCart newShoppingCart = this.createShoppingCartForUser(email);
            return modelMapper.map(newShoppingCart, GetShoppingCartDto.class);
        } else {
            ShoppingCart shoppingCart = findShoppingCartForUser.get();
            return modelMapper.map(shoppingCart, GetShoppingCartDto.class);
        }
    }

    @Override
    public ShoppingCart createShoppingCartForUser(String email) {
        User user = this.userRepository.findById(email).orElseThrow(() -> new UserNotFoundException(email));
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(user);
        shoppingCart.setStatus(ShoppingCartStatus.CREATED);
        shoppingCart.setShoppingCartItems(new ArrayList<>());
        return this.save(shoppingCart);
    }

/*    @Override
    public ShoppingCartItem addItemToCart(AddItemToCartDto addItemToCartDto) {
        ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
        Item item = this.itemRepository.findById(addItemToCartDto.getItemId()).orElseThrow(() -> new ItemNotFoundException(addItemToCartDto.getItemId()));
        Optional<ItemPrice> itemPriceSent = item.getItemPrices().stream().filter(itemPrice -> itemPrice.getId().equals(addItemToCartDto.getItemPriceId())).findAny();
        if (itemPriceSent.isPresent()) {
            shoppingCartItem.setItemPrice(itemPriceSent.get());
        } else {
            throw new ItemPriceNotFoundException(addItemToCartDto.getItemPriceId());
        }

        ShoppingCart shoppingCart = this.findById(getActiveShoppingCart(addItemToCartDto.getEmail()).getShoppingCartId());

        shoppingCartItem.setShoppingCart(shoppingCart);
        shoppingCartItem.setId(new ShoppingCartItemKey(shoppingCart.getId(), addItemToCartDto.getItemPriceId()));
        shoppingCartItem.setQuantity(addItemToCartDto.getQuantity());
        return this.shoppingCartItemRepository.save(shoppingCartItem);
    }*/

    @Override
    public ShoppingCart payShoppingCart(PayShoppingCartDto payShoppingCartDto) {
        ShoppingCart shoppingCart = findById(payShoppingCartDto.getShoppingCartId());
        shoppingCart.setStatus(ShoppingCartStatus.FINISHED);
        return this.save(shoppingCart);
    }

}