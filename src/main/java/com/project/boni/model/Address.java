package com.project.boni.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.boni.model.baseClass.BaseEntity;
import com.project.boni.model.enums.Municipality;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(number, address.number) && municipality == address.municipality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), street, number, municipality);
    }
}
