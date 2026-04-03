package com.example.demo.repositories;
import java.util.List;
import java.util.Optional;

import com.example.demo.schema.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("Select p from Product p JOIN FETCH p.category ORDER By p.id")
    List<Product> getAllProducts(); 

    @Query("Select p from Product p JOIN FETCH p.category WHERE p.id = :id")
    Optional<Product> getProductById(Long id); 
}
