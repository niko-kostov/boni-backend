package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.boni.model.baseClass.BaseTimeAuditedEntity;
import com.project.boni.model.enums.ShoppingCartStatus;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart extends BaseTimeAuditedEntity<Long, ZonedDateTime> implements Serializable {

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private ShoppingCartStatus status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "order_payed")
    private ZonedDateTime order_payed;

    @OneToMany(mappedBy = "shoppingCart", fetch = FetchType.LAZY)
    private List<ShoppingCartItem> shoppingCartItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShoppingCart that = (ShoppingCart) o;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), status);
    }
}
