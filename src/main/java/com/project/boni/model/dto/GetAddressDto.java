package com.project.boni.model.dto;

import com.project.boni.model.enums.Municipality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAddressDto implements Serializable {
    private String street;
    private Long addressId;
    private String number;
    private Municipality municipality;
    private GetLocationDto locationDto;
}
