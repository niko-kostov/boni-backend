package com.project.boni.mapper;

import com.project.boni.model.Item;
import com.project.boni.model.dto.ItemWithPriceDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ItemToItemWithPriceDtoMapper {
    private final ItemPriceToItemPriceDtoMapper itemPriceToItemPriceDtoMapper;

    public ItemToItemWithPriceDtoMapper(ItemPriceToItemPriceDtoMapper itemPriceToItemPriceDtoMapper) {
        this.itemPriceToItemPriceDtoMapper = itemPriceToItemPriceDtoMapper;
    }

    public ItemWithPriceDto from(Item item){
        ItemWithPriceDto dto = new ItemWithPriceDto();
        dto.setId(item.getId());
        dto.setDescription(item.getDescription());
        dto.setCategory(item.getCategory());
        dto.setItemImage(item.getItemImage());
        dto.setName(item.getName());
        dto.setItemPrices(item.getItemPrices().stream().map(itemPriceToItemPriceDtoMapper::from)
                .collect(Collectors.toSet()));
        return dto;
    }

    public List<ItemWithPriceDto> from(List<Item> items){
        return items.stream().map(this::from).collect(Collectors.toList());
    }
}
