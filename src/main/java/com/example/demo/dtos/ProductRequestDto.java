package com.example.demo.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.demo.schema.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
    
    Long id; 
    String name; 
    String description; 
    Category category; 
    BigDecimal rating; 
    LocalDateTime created_at; 
    LocalDateTime updated_at; 
    LocalDateTime deleted_at; 
}
