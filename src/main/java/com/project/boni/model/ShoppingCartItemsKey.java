package com.project.boni.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class ShoppingCartItemsKey implements Serializable {

    @Column(name = "shopping_cart_id")
    private Long shoppingCartId;

    @Column(name = "item_price_id")
    private Long itemPriceId;
}
