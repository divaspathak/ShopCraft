package com.example.demo.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {

    Long id; 
    String title; 
    String description; 
    String category; 
    BigDecimal rating; 
    LocalDateTime createdAt; 
    LocalDateTime updatedAt; 
    LocalDateTime deletedAt; 
}
