package com.project.boni.model.dto;

import com.project.boni.model.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderHistoryDetailsDto implements Serializable {

    @Positive
    private int quantity;

    @NotNull
    private String itemName;

    private Size size;

    @Positive
    private double itemPrice;
}
