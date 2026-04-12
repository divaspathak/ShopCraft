package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CategoryResponseDto;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.schema.Category;

@Service
public class CategoryService implements ICategoryService {
    private final CategoryRepository categoryRepository; 
    
    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository; 
    }

    public Page<Category> getAllCategories(int page, int size){

        Pageable pageable = PageRequest.of(page, size); 
        return categoryRepository.findAll(pageable); 
    }

    public Category createCategory(String name){
        Category category = Category.builder().name(name).build(); 
        return categoryRepository.save(category); 
    }

    @Override
    public CategoryResponseDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Category Not Found")); 
        return CategoryResponseDto.builder().id(category.getId()).name(category.getName()).created_at(category.getCreatedAt()).updated_at(category.getUpdatedAt()).build(); 
    }
}
