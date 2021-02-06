package com.project.boni.service.Impl;

import com.project.boni.model.Menu;
import com.project.boni.model.exceptions.MenuNotFoundException;
import com.project.boni.repository.MenuRepository;
import com.project.boni.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    private final MenuRepository menuRepository;

    public MenuServiceImpl(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    @Override
    public Menu findById(Long id) {
        return this.menuRepository.findById(id).orElseThrow(() -> new MenuNotFoundException(id));
    }

    @Override
    public Menu save(Menu menu) {
        return this.menuRepository.save(menu);
    }

    @Override
    public Menu deleteById(Long id) {
        Menu deletedMenu = this.menuRepository.findById(id).orElseThrow(() -> new MenuNotFoundException(id));
        this.menuRepository.deleteById(id);
        return deletedMenu;
    }

    @Override
    public List<Menu> findAll() {
        return this.menuRepository.findAll();
    }
}
