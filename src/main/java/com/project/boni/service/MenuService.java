package com.project.boni.service;

import com.project.boni.model.Menu;

import java.util.List;

public interface MenuService {
    Menu findById(Long id);

    Menu save(Menu menu);

    Menu deleteById(Long id);

    List<Menu> findAll();
}
