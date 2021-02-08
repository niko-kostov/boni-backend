package com.project.boni.web;

import com.project.boni.model.dto.GetShoppingCartDto;
import com.project.boni.service.ShoppingCartService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/shoppingCart", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("/get/{email}")
    public GetShoppingCartDto getShoppingCartForUser(@PathVariable String email){
        return this.shoppingCartService.getActiveShoppingCart(email);
    }
}