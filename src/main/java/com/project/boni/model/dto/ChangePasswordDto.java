package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto implements Serializable {

    @Email
    @NotBlank
    private String email;

    @NotNull
    private String oldPassword;

    @NotNull
    private String newPassword;
}
