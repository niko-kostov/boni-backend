package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddItemToCartDto implements Serializable {

    private Long shoppingCartId;

    private Long itemId;

    private Long itemPriceId;

    private Integer quantity;

}
