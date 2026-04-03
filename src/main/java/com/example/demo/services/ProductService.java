package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.dtos.ProductResponseDto;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.schema.Product;

@Service
public class ProductService implements IProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductResponseDto> getAllProducts() {
        List<Product> productList = productRepository.getAllProducts();

        return productList.stream()
                .map(product -> ProductResponseDto.builder().id(product.getId())
                        .title(product.getTitle())
                        .description(product.getDescription())
                        .category(product.getCategory().getName())
                        .rating(product.getRating())
                        .createdAt(product.getCreatedAt())
                        .updatedAt(product.getUpdatedAt()).deletedAt(product.getDeletedAt())
                        .build())

                .toList();
    }

    public Product createProduct(ProductRequestDto productRequestDto) {

        Product product = ProductMapper.convertToProduct(productRequestDto, this.categoryRepository);
        return productRepository.save(product);
    }

    public ProductResponseDto getProductById(Long id) {
        Product product = productRepository.getProductById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        return ProductResponseDto.builder().id(product.getId())
                .title(product.getTitle())
                .description((product.getDescription()))
                .category(product.getCategory().getName())
                .rating(product.getRating())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .deletedAt(product.getDeletedAt()).build();
    }
}
