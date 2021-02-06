package com.project.boni.service.Impl;

import com.project.boni.model.Category;
import com.project.boni.model.exceptions.CategoryNotFoundException;
import com.project.boni.repository.CategoryRepository;
import com.project.boni.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
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
        this.categoryRepository.deleteById(id);
        return deletedCategory;
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepository.save(category);
    }
}
