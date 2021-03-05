package com.project.boni.model.dto;

import com.project.boni.model.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderHistoryDetailsDto implements Serializable {

    private int quantity;

    private String itemName;

    private Size size;

    private double itemPrice;
}
