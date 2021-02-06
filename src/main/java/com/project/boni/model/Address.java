package com.project.boni.model;

import com.project.boni.model.baseClass.BaseEntity;
import com.project.boni.model.enums.Municipality;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "address_user")
public class Address extends BaseEntity<Long> {

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
    private User user;
}
