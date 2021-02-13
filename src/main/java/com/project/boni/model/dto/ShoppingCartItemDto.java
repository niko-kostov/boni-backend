package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItemDto implements Serializable {

    private Long itemId;

    private String itemName;

    private Long itemPriceId;

    private double itemPrice;

    private Integer quantity;
}
