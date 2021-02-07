package com.project.boni.model.dto;

import com.project.boni.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemWithPriceDto implements Serializable{

    private Long id;

    private String name;

    private byte[] itemImage;

    private String description;

    private Category category;

    private Set<ItemPriceDto> itemPrices;

}