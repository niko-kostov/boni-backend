package com.project.boni.model;

import com.project.boni.model.baseClass.BaseTimeAuditedEntity;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "boni_user")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @Column(name = "email")
    @NotBlank
    private String email;

    @NotBlank
    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "is_active")
    private boolean active;

    @Column(name = "is_deleted")
    private boolean deleted;

    @ManyToOne
    private Role role;

    @Lob
    @Column(name = "user_image")
    private byte[] profileImage;

    @Column(name = "user_phone")
    private String phoneNumber;

    @Column(name = "created_at")
    @CreatedDate
    private ZonedDateTime created_at;

    @OneToMany(mappedBy = "user")
    private Set<Address> addresses;

    @OneToMany(mappedBy = "user")
    private Set<ShoppingCart> shoppingCarts;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return active == user.active && deleted == user.deleted && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(firstname, user.firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(role, user.role) && Arrays.equals(profileImage, user.profileImage) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(created_at, user.created_at);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(email, password, firstname, lastname, active, deleted, role, phoneNumber, created_at);
        result = 31 * result + Arrays.hashCode(profileImage);
        return result;
    }
}
