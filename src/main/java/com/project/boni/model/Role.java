package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.boni.model.baseClass.BaseTimeAuditedEntity;
import com.project.boni.model.enums.ERole;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
@EntityListeners(AuditingEntityListener.class)
public class Role extends BaseTimeAuditedEntity<Long, ZonedDateTime> implements Serializable {

    @Enumerated(value = EnumType.STRING)
    @Column(length = 30)
    private ERole name;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "is_deleted")
    private boolean deleted;

    @JsonIgnore
    @OneToMany(mappedBy = "role")
    private Set<User> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Role role = (Role) o;
        return active == role.active && deleted == role.deleted && name == role.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, active, deleted);
    }
}

