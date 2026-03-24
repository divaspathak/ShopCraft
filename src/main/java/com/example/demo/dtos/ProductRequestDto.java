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
    String title;
    String description;
    String category;
    BigDecimal rating;
}
