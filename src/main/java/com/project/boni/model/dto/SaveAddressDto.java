package com.project.boni.model.dto;

import com.project.boni.model.Location;
import com.project.boni.model.User;
import com.project.boni.model.enums.Municipality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveAddressDto implements Serializable {

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    private Municipality municipality;

    private float longitude;

    private float latitude;

    @NotBlank
    @Email
    private String email;
}
