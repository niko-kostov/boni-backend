package com.project.boni.service;

import com.project.boni.model.ItemPrice;
import com.project.boni.model.dto.AddItemPriceDto;

import java.util.List;

public interface ItemPriceService {
    ItemPrice save(ItemPrice itemPrice);

    ItemPrice deleteById(Long id);

    List<ItemPrice> findAll();

    ItemPrice addItemPrice(AddItemPriceDto addItemPriceDto);
}
