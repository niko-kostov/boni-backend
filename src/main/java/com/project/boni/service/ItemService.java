package com.project.boni.service;

import com.project.boni.model.Item;
import com.project.boni.model.ItemPrice;
import com.project.boni.model.dto.EditItemDto;
import com.project.boni.model.dto.ItemWithPriceDto;
import com.project.boni.model.dto.SaveItemDto;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findById(Long id);

    Item deleteById(Long id);

    Item save(Item item);

    List<ItemWithPriceDto> findAllItemsWithPrice();

    Item saveItemWithPrice(ItemWithPriceDto itemWithPriceDto);

    Item edit(EditItemDto editItemDto);

    Item saveItemFromDto(SaveItemDto saveItemDto);
}