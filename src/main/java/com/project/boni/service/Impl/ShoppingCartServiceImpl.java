package com.project.boni.service.Impl;

import com.project.boni.model.ShoppingCart;
import com.project.boni.model.enums.ShoppingCartStatus;
import com.project.boni.model.exceptions.NoActiveShoppingCartForUserException;
import com.project.boni.model.exceptions.ShoppingCartNotFoundException;
import com.project.boni.repository.ShoppingCartRepository;
import com.project.boni.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
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
        this.shoppingCartRepository.deleteById(id);
        return deletedCart;
    }

    @Override
    public ShoppingCart getActiveShoppingCart(String email) {
         return this.shoppingCartRepository.findAll()
                .stream().filter(cart -> cart.getUser().getEmail().equals(email))
                .filter(cartForUser -> cartForUser.getStatus().equals(ShoppingCartStatus.CREATED))
                 .findFirst().orElseThrow(() -> new NoActiveShoppingCartForUserException(email));
    }
}
