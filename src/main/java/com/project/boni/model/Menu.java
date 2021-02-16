package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.boni.model.baseClass.BaseEntity;
import com.project.boni.model.baseClass.BaseTimeAuditedEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "menu")
@EntityListeners(AuditingEntityListener.class)
public class Menu extends BaseTimeAuditedEntity<Long, ZonedDateTime> implements Serializable {

    @Column(name = "menu_name")
    private String name;

    @OneToMany(mappedBy = "menu")
    private Set<Category> categories;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Menu menu = (Menu) o;
        return Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }
}