package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.boni.model.baseClass.BaseEntity;
import com.project.boni.model.enums.Municipality;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@Table(name = "address_user")
public class Address extends BaseEntity<Long> implements Serializable {

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "municipality")
    private Municipality municipality;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}