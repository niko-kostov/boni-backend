package com.project.boni.model;

import com.project.boni.model.baseClass.BaseEntity;
import com.project.boni.model.enums.Size;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "item_price")
public class ItemPrice extends BaseEntity<Long> {

    @Column(name = "price")
    private double price;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "size")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;


}
