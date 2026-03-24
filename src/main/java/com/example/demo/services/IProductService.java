
package com.example.demo.services;
import java.util.List;

import com.example.demo.dtos.ProductRequestDto;
import com.example.demo.schema.Product;

public interface IProductService {
    List<Product> getAllProducts(); 

    Product createProduct(ProductRequestDto productRequestDto); 
}
