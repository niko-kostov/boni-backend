package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.boni.model.baseClass.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
public class Category extends BaseEntity<Long> implements Serializable {

    @Column(name = "category_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    private Menu menu;

    @OneToMany(mappedBy = "category")
    private Set<Item> items;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}
