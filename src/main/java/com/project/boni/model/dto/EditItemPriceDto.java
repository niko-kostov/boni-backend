package com.project.boni.model.dto;

import com.project.boni.model.enums.Size;
import lombok.Data;

@Data
public class EditItemPriceDto {

    private Long id;

    private double price;

    private Size size;
}
