package com.project.boni.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "shopping_cart_items")
public class ShoppingCartItems {

    @EmbeddedId
    @Column(name = "shopping_cart_items_id")
    private ShoppingCartItemsKey id;

    @ManyToOne
    @MapsId("shoppingCartId")
    @JoinColumn(name = "shopping_cart_id")
    private ShoppingCart shoppingCart;

    @ManyToOne
    @MapsId("itemPriceId")
    @JoinColumn(name = "item_price_id")
    private ItemPrice itemPrice;

    @Column(name = "quantity")
    private Integer quantity;
}
