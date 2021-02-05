package com.project.boni.model;

import com.project.boni.model.baseClass.BaseTimeAuditedEntity;
import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.ZonedDateTime;

@Entity
@Data
@Table(name = "boni_user")
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

    @Lob
    @Column(name = "user_image")
    private byte[] profileImage;

    @Column(name = "user_phone")
    private String phoneNumber;

    @Column(name = "created_at")
    @CreatedDate
    private ZonedDateTime created_at;
}
