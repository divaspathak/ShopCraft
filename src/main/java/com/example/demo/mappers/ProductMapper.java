package com.example.demo.mappers;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.schema.Category;
import com.example.demo.schema.Product;

public class ProductMapper {

    public static Product convertToProduct(ProductRequestDto productRequestDto, CategoryRepository categoryRepository) {

        Category category = categoryRepository.findCategory(productRequestDto.getCategory()); 

        return Product.builder().title(productRequestDto.getTitle()).description(productRequestDto.getDescription())
                .category(category).rating(productRequestDto.getRating()).build();
    }
}
