package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLocationDto implements Serializable {
    private float locationLongitude;
    private float locationLatitude;
    private Long locationId;
}
