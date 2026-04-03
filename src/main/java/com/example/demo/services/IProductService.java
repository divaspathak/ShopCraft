
package com.example.demo.services;
import java.util.List;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.dtos.ProductResponseDto;
import com.example.demo.schema.Product;

public interface IProductService {
    List<ProductResponseDto> getAllProducts(); 

    Product createProduct(ProductRequestDto productRequestDto); 

    ProductResponseDto getProductById(Long id); 
}
