package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.boni.model.baseClass.BaseTimeAuditedEntity;
import com.project.boni.model.enums.ERole;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
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
}

