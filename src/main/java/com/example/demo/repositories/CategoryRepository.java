package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.schema.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>  {

    @Query(value = "SELECT * FROM categories WHERE name = :category", nativeQuery = true)
    Category findCategory(String category); 
}
