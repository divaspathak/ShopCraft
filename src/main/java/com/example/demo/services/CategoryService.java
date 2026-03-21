package com.example.demo.services;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
        return categoryRepository.save(new Category(name)); 
    }
}
