package com.project.boni.model.dto;

import com.project.boni.model.Location;
import com.project.boni.model.User;
import com.project.boni.model.enums.Municipality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditAddressDto implements Serializable {
    private Long id;
    private String street;
    private String number ;
    private Municipality municipality ;
    private Location location ;
    private String email;
}
