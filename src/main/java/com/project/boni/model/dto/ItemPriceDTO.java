package com.project.boni.model.dto;

import com.project.boni.model.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemPriceDTO {

    private Size size;

    private double price;
}
