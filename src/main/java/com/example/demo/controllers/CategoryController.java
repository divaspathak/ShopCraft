package com.example.demo.controllers;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.RequestCategoryDto;
import com.example.demo.schema.Category;
import com.example.demo.services.ICategoryService;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {

    private final ICategoryService categoryService; 

    public CategoryController(ICategoryService categoryService){
        this.categoryService = categoryService; 
    }
    
    @GetMapping("/categories")
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0")int page, @RequestParam(defaultValue = "10") int size){
        return categoryService.getAllCategories(page, size); 
    }

    @PostMapping("/category")
    public Category createCategory(@RequestBody RequestCategoryDto request){
        return categoryService.createCategory(request.getName()); 
    }
}
