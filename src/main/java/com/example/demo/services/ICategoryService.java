package com.example.demo.services;

import org.springframework.data.domain.Page;

import com.example.demo.schema.Category;

public interface ICategoryService {
    public Page<Category> getAllCategories(int page, int size); 
    public Category createCategory(String name); 
}
