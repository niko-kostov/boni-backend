package com.project.boni.service;

import com.project.boni.model.Category;
import com.project.boni.model.dto.EditCategoryDto;
import com.project.boni.model.dto.SaveCategoryDto;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category deleteById(Long id);

    Category save(Category category);

    Category edit(EditCategoryDto editCategoryDto);

    Category saveFromDto(SaveCategoryDto saveCategoryDto);
}
