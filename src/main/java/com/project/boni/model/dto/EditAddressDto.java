package com.project.boni.model.dto;

import com.project.boni.model.enums.Municipality;
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
public class EditAddressDto implements Serializable {

    @NotNull
    private Long addressId;

    @NotBlank
    private String street;

    @NotBlank
    private String number;

    private Municipality municipality;

    @NotNull
    private float longitude;

    @NotNull
    private float latitude;
}
