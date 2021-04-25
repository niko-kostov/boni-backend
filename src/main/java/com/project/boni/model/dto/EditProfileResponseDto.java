package com.project.boni.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EditProfileResponseDto implements Serializable {

    private String fullName;

    private String phoneNumber;
}
