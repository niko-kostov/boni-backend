package com.project.boni.model;

import com.project.boni.model.baseClass.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "category")
public class Category extends BaseEntity<Long> {

    @Column(name = "category_name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

    @OneToMany(mappedBy = "category")
    private Set<Item> items;
}
