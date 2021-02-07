package com.project.boni.model.dto;

import com.project.boni.model.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemPriceDto implements Serializable {

    private Long id;

    private Size size;

    private double price;
}
