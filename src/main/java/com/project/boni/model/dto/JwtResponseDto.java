package com.project.boni.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
public class JwtResponseDto implements Serializable {

    private String accessToken;

    private String tokenType = "Bearer";

    @NotBlank
    private String email;

    @NotBlank
    private String fullName;

    @NotNull
    private Long activeShoppingCartId;

    private List<String> roles;
}
