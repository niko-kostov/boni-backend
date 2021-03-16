package com.project.boni.web;

import com.project.boni.model.ShoppingCart;
import com.project.boni.model.ShoppingCartItem;
import com.project.boni.model.dto.*;
import com.project.boni.service.ShoppingCartService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/shoppingCart", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/user/{email}")
    public GetShoppingCartDto getShoppingCartForUser(@PathVariable String email){
        return this.shoppingCartService.getActiveShoppingCart(email);
    }

    @PostMapping("/user")
    public ShoppingCartItem addItemToCart(@RequestBody AddItemToCartDto addItemToCartDto){
        return this.shoppingCartService.addItemToCart(addItemToCartDto);
    }

    @PatchMapping("/user/pay")
    public ShoppingCart payShoppingCart(@RequestBody PayShoppingCartDto payShoppingCartDto){
        return this.shoppingCartService.payShoppingCart(payShoppingCartDto);
    }

    @GetMapping("/user/getOrderHistory/{email}")
    public List<GetOrderHistoryDto> getOrderHistoryForUser(@PathVariable String email){
        return this.shoppingCartService.getOrderHistoryForUser(email);
    }

    @GetMapping("/user/getOrderHistoryDetails/{id}")
    public List<GetOrderHistoryDetailsDto> getOrderHistoryDetails(@PathVariable Long id){
        return this.shoppingCartService.getOrderHistoryDetails(id);
    }
}