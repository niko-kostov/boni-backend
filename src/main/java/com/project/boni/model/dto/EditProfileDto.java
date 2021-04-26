package com.project.boni.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EditProfileDto implements Serializable {

    private String firstName;

    private String lastName;

    private String phoneNumber;
}
