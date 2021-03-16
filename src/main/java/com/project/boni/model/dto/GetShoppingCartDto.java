package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetShoppingCartDto implements Serializable {

    @NotNull
    private Long shoppingCartId;

    private List<ShoppingCartItemDto> shoppingCartItemDtoList;
}
