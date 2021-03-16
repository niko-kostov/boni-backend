package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeShoppingCartItemQuantityDto implements Serializable {

    @NotNull
    private Long shoppingCartId;

    @NotNull
    private Long itemPriceId;

    @Positive
    private Integer quantity;
}
