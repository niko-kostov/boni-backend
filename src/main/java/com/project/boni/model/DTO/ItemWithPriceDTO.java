package com.project.boni.model.DTO;

import com.project.boni.model.Item;
import com.project.boni.model.ItemPrice;
import lombok.Data;

import java.util.List;

@Data
public class ItemWithPriceDTO {

    private Item item;

    private List<ItemPrice> itemPrice;
}
