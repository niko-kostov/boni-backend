package com.project.boni.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ShoppingCartItemKey implements Serializable {

    @Column(name = "shopping_cart_id")
    private Long shoppingCartId;

    @Column(name = "item_price_id")
    private Long itemPriceId;
}