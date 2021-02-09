package com.project.boni.model.dto;

import com.project.boni.model.Location;
import com.project.boni.model.User;
import com.project.boni.model.enums.Municipality;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveAddressDto implements Serializable {
    private String street;
    private String number ;
    private Municipality municipality ;
    private float longitude;
    private float latitude;
    private String email;
}
