package com.project.boni.model.dto;

import com.project.boni.model.enums.Municipality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressDto implements Serializable {

    @NotBlank
    private String street;

    @NotNull
    private Long addressId;

    @NotBlank
    private String number;

    private Municipality municipality;

    private GetLocationDto locationDto;
}
