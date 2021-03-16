package com.project.boni.model.dto;

import com.project.boni.model.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartItemDto implements Serializable {

    @NotNull
    private Long itemId;

    @NotBlank
    private String itemName;

    @NotNull
    private Long itemPriceId;

    @Positive
    private double itemPrice;

    @NotNull
    private Size itemPriceSize;

    @Positive
    private Integer quantity;
}
