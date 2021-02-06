package com.project.boni.model;

import com.project.boni.model.baseClass.BaseEntity;
import com.project.boni.model.baseClass.BaseTimeAuditedEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "menu")
public class Menu extends BaseTimeAuditedEntity<Long, ZonedDateTime> implements Serializable {

    @Column(name = "menu_name")
    private String name;

    @OneToMany(mappedBy = "menu")
    private Set<Category> categories;
}