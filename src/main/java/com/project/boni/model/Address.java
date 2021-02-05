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

    private String street;

    private String number;

    @Enumerated(value = EnumType.STRING)
    private Municipality municipality;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;
}
