package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.schema.Product;
import com.example.demo.services.IProductService;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    private final IProductService productService; 

    public ProductController(IProductService productService){
        this.productService = productService; 
    }
    @GetMapping("/products")
    List<Product> getAllProducts(){
        return productService.getAllProducts(); 
    }
}
