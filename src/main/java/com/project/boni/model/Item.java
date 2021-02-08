package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.boni.model.baseClass.BaseEntity;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "item")
public class Item extends BaseEntity<Long> implements Serializable {

    @Column(name = "item_name")
    private String name;

    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    @Column(name = "item_image")
    private byte[] itemImage;

    @Column(name = "item_description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonIgnore
    private Category category;

    @OneToMany(mappedBy = "item")
    private Set<ItemPrice> itemPrices;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) &&
                Arrays.equals(itemImage, item.itemImage) &&
                Objects.equals(description, item.description);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), name, description);
        result = 31 * result + Arrays.hashCode(itemImage);
        return result;
    }
}
