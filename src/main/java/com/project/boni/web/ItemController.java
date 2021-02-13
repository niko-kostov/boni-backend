package com.project.boni.web;

import com.project.boni.model.Item;
import com.project.boni.model.dto.EditItemDto;
import com.project.boni.model.dto.ItemWithPriceDto;
import com.project.boni.model.dto.SaveItemDto;
import com.project.boni.service.ItemService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/item", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @DeleteMapping("/admin/{id}")
    public Item deleteItem(@PathVariable Long id){
        return this.itemService.deleteById(id);
    }

    @PatchMapping("/admin")
    public Item editItem(@RequestBody EditItemDto editItemDto){
        return this.itemService.edit(editItemDto);
    }

    @PostMapping("/admin")
    public Item addItem(@RequestBody SaveItemDto saveItemDto){
        return this.itemService.saveItemFromDto(saveItemDto);
    }
}
