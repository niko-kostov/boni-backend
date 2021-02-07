package com.project.boni.service.Impl;

import com.project.boni.mapper.ItemToItemWithPriceDtoMapper;
import com.project.boni.model.Item;
import com.project.boni.model.dto.ItemWithPriceDto;
import com.project.boni.model.exceptions.ItemNotFoundException;
import com.project.boni.repository.ItemRepository;
import com.project.boni.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemToItemWithPriceDtoMapper itemToItemWithPriceDtoMapper;

    public ItemServiceImpl(ItemRepository itemRepository, ItemToItemWithPriceDtoMapper itemToItemWithPriceDtoMapper) {
        this.itemRepository = itemRepository;
        this.itemToItemWithPriceDtoMapper = itemToItemWithPriceDtoMapper;
    }

    @Override
    public List<Item> findAll() {
        return this.itemRepository.findAll();
    }

    @Override
    public Item findById(Long id) {
        return this.itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
    }

    @Override
    public Item deleteById(Long id) {
        Item deletedItem = this.itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        this.itemRepository.deleteById(id);
        return deletedItem;
    }

    @Override
    public Item save(Item item) {
        return this.itemRepository.save(item);
    }

    @Override
    public List<ItemWithPriceDto> findAllItemsWithPrice() {
        return itemToItemWithPriceDtoMapper.from(this.findAll());
    }
}