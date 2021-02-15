package com.project.boni.service.Impl;

import com.project.boni.model.Category;
import com.project.boni.model.Menu;
import com.project.boni.model.dto.EditCategoryDto;
import com.project.boni.model.dto.SaveCategoryDto;
import com.project.boni.model.exceptions.CategoryNotFoundException;
import com.project.boni.model.exceptions.MenuNotExistException;
import com.project.boni.repository.*;
import com.project.boni.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;
    private final ItemPriceRepository itemPriceRepository;
    private final MenuRepository menuRepository;
    private final ShoppingCartItemRepository shoppingCartItemRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ItemRepository itemRepository, ItemPriceRepository itemPriceRepository, MenuRepository menuRepository, ShoppingCartItemRepository shoppingCartItemRepository) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
        this.itemPriceRepository = itemPriceRepository;
        this.menuRepository = menuRepository;
        this.shoppingCartItemRepository = shoppingCartItemRepository;
    }

    @Override
    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public Category deleteById(Long id) {
        Category deletedCategory = this.categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        deletedCategory.getItems().forEach(item -> item.getItemPrices()
                .forEach(itemPrice -> this.shoppingCartItemRepository
                        .deleteAll(this.shoppingCartItemRepository.findByIdItemPriceId(itemPrice.getId()))));
        deletedCategory.getItems().forEach(item -> this.itemPriceRepository.deleteAll(item.getItemPrices()));
        this.itemRepository.deleteAll(deletedCategory.getItems());
        this.categoryRepository.deleteById(id);
        return deletedCategory;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category edit(EditCategoryDto editCategoryDto) {
        Category category = this.findById(editCategoryDto.getId());
        category.setName(editCategoryDto.getName());
        return this.categoryRepository.save(category);
    }

    @Override
    public Category saveFromDto(SaveCategoryDto saveCategoryDto) {
        Category category = new Category();
        Menu menu = this.menuRepository.findAll().stream().findFirst().orElseThrow(MenuNotExistException::new);
        category.setName(saveCategoryDto.getName());
        category.setItems(new HashSet<>());
        category.setMenu(menu);
        return this.categoryRepository.save(category);
    }
}
