package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderHistoryDto implements Serializable {

    private double totalPrice;

    private ZonedDateTime datePayed;

    private Long id;
}
