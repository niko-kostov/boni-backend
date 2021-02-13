package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddItemToCartDto implements Serializable {

    private Long itemId;

    private Long itemPriceId;

    private String email;

    private Integer quantity;

}
