package com.example.demo.mappers;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.schema.Product;

public class ProductMapper {

    public static Product convertToProduct(ProductRequestDto productRequestDto) {

        return Product.builder().title(productRequestDto.getName()).description(productRequestDto.getDescription())
                .category(productRequestDto.getCategory()).rating(productRequestDto.getRating()).build();
    }
}
