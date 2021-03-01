package com.project.boni.web;

import com.project.boni.model.ItemPrice;
import com.project.boni.service.ItemPriceService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/itemPrice", produces = MediaType.APPLICATION_JSON_VALUE)
public class ItemPriceController {
    private final ItemPriceService itemPriceService;

    public ItemPriceController(ItemPriceService itemPriceService) {
        this.itemPriceService = itemPriceService;
    }

    @DeleteMapping("/admin/{id}")
    public ItemPrice deleteItemPrice(@PathVariable Long id){
        return this.itemPriceService.deleteById(id);
    }
}