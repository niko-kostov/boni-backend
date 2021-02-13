package com.project.boni.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ShoppingCartItemKey implements Serializable {

    @Column(name = "shopping_cart_id")
    private Long shoppingCartId;

    @Column(name = "item_price_id")
    private Long itemPriceId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItemKey that = (ShoppingCartItemKey) o;
        return Objects.equals(shoppingCartId, that.shoppingCartId) && Objects.equals(itemPriceId, that.itemPriceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoppingCartId, itemPriceId);
    }
}