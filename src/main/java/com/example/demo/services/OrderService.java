package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.OrderItemsResponseDto;
import com.example.demo.dtos.OrderRequestDto;
import com.example.demo.dtos.OrderResponseDto;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.schema.Order;
import com.example.demo.schema.OrderProducts;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
    //     Order order = this.orderRepository.createOrder(orderRequestDto);

    //     List<OrderProducts> orderItems = order.getOrderItems();

    //     List<OrderItemsDto> orderItemsDto = orderItems.stream().map(item -> OrderItemsDto.builder().productID(item.getProductId())
    //             .quantity(item.getQuantity()).build()).toList();

    //     return OrderResponseDto.builder().id(order.getId()).orderItems(orderItemsDto).build();
    // }
}
