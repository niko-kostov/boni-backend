package com.project.boni.model.dto;

import com.project.boni.model.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItemDto implements Serializable {

    private Long itemId;

    private String itemName;

    private Long itemPriceId;

    private double itemPrice;

    private Size itemPriceSize;

    private Integer quantity;
}
