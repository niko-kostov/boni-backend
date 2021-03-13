package com.project.boni.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponseDto {
    private String accessToken;
    private String tokenType = "Bearer";
    private String email;
    private String fullName;
    private List<String> roles;
}
