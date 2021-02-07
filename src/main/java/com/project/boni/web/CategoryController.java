package com.project.boni.web;

import com.project.boni.model.Category;
import com.project.boni.model.dto.EditCategoryDto;
import com.project.boni.model.dto.SaveCategoryDto;
import com.project.boni.service.CategoryService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(value = "api/category", produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/edit")
    public Category editCategory (@RequestBody EditCategoryDto editCategoryDto){
        return this.categoryService.edit(editCategoryDto);
    }

    @PostMapping("/add")
    public Category addCategory (@RequestBody SaveCategoryDto saveCategoryDto){
        return this.categoryService.saveFromDto(saveCategoryDto);
    }

    @DeleteMapping("/delete/{id}")
    public Category deleteCategory(@PathVariable Long id){
        return this.categoryService.deleteById(id);
    }
}
