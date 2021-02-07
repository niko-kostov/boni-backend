package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.boni.model.baseClass.BaseEntity;
import com.project.boni.model.enums.Size;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
@Table(name = "item_price")
public class ItemPrice extends BaseEntity<Long> implements Serializable {

    @Column(name = "price")
    private double price;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "size")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonIgnore
    private Item item;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ItemPrice itemPrice = (ItemPrice) o;
        return Double.compare(itemPrice.price, price) == 0 &&
                size == itemPrice.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), price, size);
    }
}
