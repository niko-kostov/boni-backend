package com.project.boni.service;

import com.project.boni.model.Item;
import com.project.boni.model.dto.ItemWithPriceDto;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findById(Long id);

    Item deleteById(Long id);

    Item save(Item item);

    List<ItemWithPriceDto> findAllItemsWithPrice();
}