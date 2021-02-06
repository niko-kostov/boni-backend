package com.project.boni.model;

import com.project.boni.model.baseClass.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "item")
public class Item extends BaseEntity<Long> {

    @Column(name = "item_name")
    private String name;

    @Lob
    @Column(name = "item_image")
    private byte[] itemImage;

    @Column(name = "item_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "item")
    private Set<ItemPrice> itemPrices;
}
