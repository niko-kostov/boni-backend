package com.project.boni.web;

import com.project.boni.model.ShoppingCartItem;
import com.project.boni.model.dto.IncreaseShoppingCartItemQuantityDto;
import com.project.boni.service.ShoppingCartItemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "/api/shoppingCartItem", produces = MediaType.APPLICATION_JSON_VALUE)
public class ShoppingCartItemController {
    private final ShoppingCartItemService shoppingCartItemService;

    public ShoppingCartItemController(ShoppingCartItemService shoppingCartItemService) {
        this.shoppingCartItemService = shoppingCartItemService;
    }

    @PatchMapping("/user/changeQuantity")
    public ShoppingCartItem increaseQuantityOfItem(@RequestBody IncreaseShoppingCartItemQuantityDto increaseShoppingCartItemQuantityDto){
        return this.shoppingCartItemService.increaseQuantity(increaseShoppingCartItemQuantityDto);
    }

    @DeleteMapping("/user/shoppingCart/{shoppingCartId}/itemPrice/{itemPriceId}")
    public ShoppingCartItem deleteItemFromCart(@PathVariable Long shoppingCartId, @PathVariable Long itemPriceId){
        return this.shoppingCartItemService.deleteItemFromCart(shoppingCartId, itemPriceId);
    }
}
