package com.project.boni.service.Impl;

import com.project.boni.model.dto.ItemPriceDTO;
import com.project.boni.model.dto.ItemWithPriceDTO;
import com.project.boni.model.Item;
import com.project.boni.model.ItemPrice;
import com.project.boni.model.exceptions.ItemNotFoundException;
import com.project.boni.repository.ItemPriceRepository;
import com.project.boni.repository.ItemRepository;
import com.project.boni.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ItemPriceRepository itemPriceRepository;

    public ItemServiceImpl(ItemRepository itemRepository, ItemPriceRepository itemPriceRepository) {
        this.itemRepository = itemRepository;
        this.itemPriceRepository = itemPriceRepository;
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

    // Connect Item with all his available prices
    @Override
    public List<ItemWithPriceDTO> findAllWithPrices() {
        List<Item> itemList = this.itemRepository.findAll();
        List<ItemWithPriceDTO> itemWithPriceDTOList = new ArrayList<>();

        for (Item item : itemList){
            ItemWithPriceDTO itemWithPriceDTO = new ItemWithPriceDTO();
            itemWithPriceDTO.setItem(item);
            List<ItemPriceDTO> pricesForItemDTO = new ArrayList<>();

            item.getItemPrices()
                    .forEach(itemPrice -> pricesForItemDTO.add(new ItemPriceDTO(itemPrice.getSize(), itemPrice.getPrice())));

            itemWithPriceDTO.setItemPrice(pricesForItemDTO);
            itemWithPriceDTOList.add(itemWithPriceDTO);
        }
        return itemWithPriceDTOList;
    }

}