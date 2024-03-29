package com.project.boni.service.Impl;

import com.project.boni.model.Item;
import com.project.boni.model.ItemPrice;
import com.project.boni.model.dto.AddItemPriceDto;
import com.project.boni.model.exceptions.ItemNotFoundException;
import com.project.boni.model.exceptions.ItemPriceNotFoundException;
import com.project.boni.repository.ItemPriceRepository;
import com.project.boni.repository.ItemRepository;
import com.project.boni.repository.ShoppingCartItemRepository;
import com.project.boni.service.ItemPriceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPriceServiceImpl implements ItemPriceService {
    private final ItemPriceRepository itemPriceRepository;
    private final ItemRepository itemRepository;
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    public ItemPriceServiceImpl(ItemPriceRepository itemPriceRepository, ItemRepository itemRepository, ShoppingCartItemRepository shoppingCartItemRepository) {
        this.itemPriceRepository = itemPriceRepository;
        this.itemRepository = itemRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    @Override
    public ItemPrice save(ItemPrice itemPrice) {
        return this.itemPriceRepository.save(itemPrice);
    }

    @Override
    public ItemPrice deleteById(Long id) {
        ItemPrice deletedItemPrice = this.itemPriceRepository.findById(id).orElseThrow(() -> new ItemPriceNotFoundException(id));
        this.shoppingCartItemRepository.deleteAll(this.shoppingCartItemRepository.findByIdItemPriceId(id));
        this.itemPriceRepository.deleteById(id);
        return deletedItemPrice;
    }

    @Override
    public List<ItemPrice> findAll() {
        return this.itemPriceRepository.findAll();
    }

    @Override
    public ItemPrice addItemPrice(AddItemPriceDto addItemPriceDto) {
        Item item = this.itemRepository.findById(addItemPriceDto.getItemId())
                .orElseThrow(() -> new ItemNotFoundException(addItemPriceDto.getItemId()));

        ItemPrice itemPrice = new ItemPrice();
        itemPrice.setItem(item);
        itemPrice.setPrice(addItemPriceDto.getPrice());
        itemPrice.setSize(addItemPriceDto.getSize());
        return this.itemPriceRepository.save(itemPrice);
    }

}