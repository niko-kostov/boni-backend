package com.project.boni.web;

import com.project.boni.model.Menu;
import com.project.boni.service.MenuService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/menu", produces = MediaType.APPLICATION_JSON_VALUE)
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public Menu getMenu(){
        return this.menuService.findFirst();
    }
}
