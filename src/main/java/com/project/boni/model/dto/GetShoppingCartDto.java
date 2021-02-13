package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetShoppingCartDto implements Serializable {

    private Long shoppingCartId;

    List<ShoppingCartItemDto> shoppingCartItemDtoList;
}
