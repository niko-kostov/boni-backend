package com.project.boni.model.dto;

import com.project.boni.model.enums.Size;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class EditItemPriceDto {

    @NotNull
    private Long id;

    @Positive
    private double price;

    @NotNull
    private Size size;
}
