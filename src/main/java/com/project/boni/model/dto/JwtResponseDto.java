package com.project.boni.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class JwtResponseDto {

    private String accessToken;

    private String tokenType = "Bearer";

    @NotBlank
    private String email;

    @NotBlank
    private String fullName;

    private List<String> roles;
}
