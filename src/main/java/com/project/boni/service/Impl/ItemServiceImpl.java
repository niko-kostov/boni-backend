package com.project.boni.service.Impl;

import com.project.boni.mapper.ItemToItemWithPriceDtoMapper;
import com.project.boni.model.Category;
import com.project.boni.model.Item;
import com.project.boni.model.ItemPrice;
import com.project.boni.model.dto.*;
import com.project.boni.model.exceptions.CategoryNotFoundException;
import com.project.boni.model.exceptions.ItemNotFoundException;
import com.project.boni.model.exceptions.ItemPriceNotFoundException;
import com.project.boni.repository.CategoryRepository;
import com.project.boni.repository.ItemPriceRepository;
import com.project.boni.repository.ItemRepository;
import com.project.boni.repository.ShoppingCartItemRepository;
import com.project.boni.service.ItemService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final ItemPriceRepository itemPriceRepository;
    private final ShoppingCartItemRepository shoppingCartItemRepository;
    private final ItemToItemWithPriceDtoMapper itemToItemWithPriceDtoMapper;

    public ItemServiceImpl(ItemRepository itemRepository, CategoryRepository categoryRepository, ItemPriceRepository itemPriceRepository, ShoppingCartItemRepository shoppingCartItemRepository, ItemToItemWithPriceDtoMapper itemToItemWithPriceDtoMapper) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
        this.itemPriceRepository = itemPriceRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
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
    @Transactional
    public Item deleteById(Long id) {
        Item deletedItem = this.itemRepository.findById(id).orElseThrow(() -> new ItemNotFoundException(id));
        deletedItem.getItemPrices().forEach(itemPrice -> this.shoppingCartItemRepository
                .deleteAll(this.shoppingCartItemRepository.findByIdItemPriceId(itemPrice.getId())));
        this.itemPriceRepository.deleteAll(deletedItem.getItemPrices());
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

    @Override
    public Item saveItemWithPrice(ItemWithPriceDto itemWithPriceDto) {
        return null;
    }

    @Override
    public Item edit(EditItemDto editItemDto) {
        Item item = this.findById(editItemDto.getId());
        item.setCategory(this.categoryRepository.findById(editItemDto.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException(editItemDto.getCategoryId())));
        item.setDescription(editItemDto.getDescription());
        item.setItemImage(editItemDto.getItemImage());
        item.setName(editItemDto.getName());

        return this.itemRepository.save(item);
    }

    @Override
    @Transactional
    public Item saveItemFromDto(SaveItemDto saveItemDto) {
        Category category = this.categoryRepository.findById(saveItemDto.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException(saveItemDto.getCategoryId()));
        Item item = new Item();
        item.setName(saveItemDto.getName());
        item.setItemImage(saveItemDto.getItemImage());
        item.setDescription(saveItemDto.getDescription());
        item.setCategory(category);

        Set<ItemPrice> itemPrices = new HashSet<>();
        item.setItemPrices(itemPrices);
        this.itemRepository.save(item);
        this.itemPriceRepository.saveAll(itemPrices);
        return item;
    }
}