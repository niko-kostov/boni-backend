package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLocationDto implements Serializable {

    @NotNull
    private float locationLongitude;

    @NotNull
    private float locationLatitude;

    @NotNull
    private Long locationId;
}
