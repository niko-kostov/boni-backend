package com.project.boni.model;

import com.project.boni.model.baseClass.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "location_address")
public class Location extends BaseEntity<Long> {

    @Column(name = "longitude")
    private float longitude;

    @Column(name = "latitude")
    private float latitude;

    @OneToOne(mappedBy = "location")
    private Address address;
}
