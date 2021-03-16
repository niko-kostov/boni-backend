package com.project.boni.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetOrderHistoryDto implements Serializable {

    @Positive
    private double totalPrice;

    private ZonedDateTime datePayed;

    @NotNull
    private Long id;
}
