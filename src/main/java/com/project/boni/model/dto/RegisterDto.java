package com.project.boni.model.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
}
