package com.example.demo.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.mappers.ProductMapper;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.schema.Product;

@Service
public class ProductService implements IProductService{
    private final ProductRepository productRepository; 

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository; 
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll(); 
    } 

    public Product createProduct(ProductRequestDto productRequestDto){

        Product product = ProductMapper.convertToProduct(productRequestDto); 

        return productRepository.save(product); 
    }
}
