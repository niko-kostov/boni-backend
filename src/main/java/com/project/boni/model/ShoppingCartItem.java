package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "shopping_cart_items")
public class ShoppingCartItem implements Serializable {

    @EmbeddedId
    @Column(name = "shopping_cart_items_id")
    private ShoppingCartItemKey id;

    @ManyToOne
    @MapsId("shoppingCartId")
    @JoinColumn(name = "shopping_cart_id")
    @JsonIgnore
    private ShoppingCart shoppingCart;

    @ManyToOne
    @MapsId("itemPriceId")
    @JoinColumn(name = "item_price_id")
    private ItemPrice itemPrice;

    @Column(name = "quantity")
    @Positive
    private Integer quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartItem that = (ShoppingCartItem) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }
}
