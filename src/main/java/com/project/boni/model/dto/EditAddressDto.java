package com.project.boni.model.dto;

import com.project.boni.model.enums.Municipality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditAddressDto implements Serializable {
    private Long addressId;
    private String street;
    private String number;
    private Municipality municipality;
    private float longitude;
    private float latitude;
    private Long locationId;
    private String email;
}
