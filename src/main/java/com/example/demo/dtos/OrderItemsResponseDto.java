package com.example.demo.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsResponseDto {

    private Long productId;

    private String productName;

    private Long quantity;

    private BigDecimal productPrice;

    private String productImage;

    private BigDecimal subTotal; 

}
