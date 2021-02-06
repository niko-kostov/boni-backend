package com.project.boni.service;

import com.project.boni.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Long id);

    Category deleteById(Long id);

    Category save(Category category);
}
