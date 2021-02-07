package com.project.boni.service.Impl;

import com.project.boni.model.ItemPrice;
import com.project.boni.model.dto.SaveItemDto;
import com.project.boni.model.exceptions.ItemPriceNotFoundException;
import com.project.boni.repository.ItemPriceRepository;
import com.project.boni.service.ItemPriceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemPriceServiceImpl implements ItemPriceService {
    private final ItemPriceRepository itemPriceRepository;

    public ItemPriceServiceImpl(ItemPriceRepository itemPriceRepository) {
        this.itemPriceRepository = itemPriceRepository;
    }

    @Override
    public ItemPrice save(ItemPrice itemPrice) {
        return this.itemPriceRepository.save(itemPrice);
    }

    @Override
    public ItemPrice deleteById(Long id) {
        ItemPrice deletedItemPrice = this.itemPriceRepository.findById(id).orElseThrow(() -> new ItemPriceNotFoundException(id));
        this.itemPriceRepository.deleteById(id);
        return deletedItemPrice;
    }

    @Override
    public List<ItemPrice> findAll() {
        return this.itemPriceRepository.findAll();
    }
}
