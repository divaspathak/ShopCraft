package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.OrderRequestDto;
import com.example.demo.dtos.OrderResponseDto;

public interface IOrderService {

    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto); 
    public List<OrderResponseDto> getAllOrders(); 
}