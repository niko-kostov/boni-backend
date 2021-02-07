package com.project.boni.mapper;

import com.project.boni.model.ItemPrice;
import com.project.boni.model.dto.ItemPriceDto;
import org.springframework.stereotype.Component;

@Component
public class ItemPriceToItemPriceDtoMapper {

    public ItemPriceDto from(ItemPrice itemPrice){
        ItemPriceDto dto = new ItemPriceDto();
        dto.setId(itemPrice.getId());
        dto.setSize(itemPrice.getSize());
        dto.setPrice(itemPrice.getPrice());
        return dto;
    }
}
