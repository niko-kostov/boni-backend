package com.project.boni.service;

import com.project.boni.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> findAll();

    Item findById(Long id);

    Item deleteById(Long id);

    Item save(Item item);
}