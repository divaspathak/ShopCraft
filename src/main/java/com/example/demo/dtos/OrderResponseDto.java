package com.example.demo.dtos;

import java.time.LocalDateTime;
import java.util.List;

import com.example.demo.enums.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponseDto {
    Long id;
    OrderStatus status;
    List<OrderItemsResponseDto> orderItems;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
