package com.example.demo.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dtos.OrderItemsResponseDto;
import com.example.demo.dtos.OrderRequestDto;
import com.example.demo.dtos.OrderResponseDto;
import com.example.demo.enums.OrderStatus;
import com.example.demo.repositories.OrderProductsRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.schema.Order;
import com.example.demo.schema.OrderProducts;
import com.example.demo.schema.Product;

@Service
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;
    private final OrderProductsRepository orderProductsRepository;
    private final ProductRepository productRepository; 

    public OrderService(OrderRepository orderRepository, OrderProductsRepository orderProductsRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.orderProductsRepository = orderProductsRepository;
        this.productRepository = productRepository; 
    }

    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {
        Order order = Order.builder().status(OrderStatus.PENDING).build();

        List<OrderProducts> orderItems = orderRequestDto.getOrderItems().stream()
                .map(item -> {
                    Product product = productRepository.findById(item.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));
                    
                    return OrderProducts.builder()
                        .order(order)
                        .product(product)
                        .quantity(item.getQuantity())
                        .build(); 
                })

                .collect(Collectors.toList());

        orderRepository.save(order);
        orderProductsRepository.saveAll(orderItems);

        List<OrderItemsResponseDto> orderItemsDto = orderItems.stream().map(items -> OrderItemsResponseDto.builder().id(items.getId()).productId(items.getProduct().getId()).productName(items.getProduct().getTitle()).rating(items.getProduct().getRating()).quantity(items.getQuantity()).productPrice(items.getProduct().getPrice()).build()).collect(Collectors.toList()); 
        
        return OrderResponseDto.builder().id(order.getId()).orderItems(orderItemsDto).build();
    }

    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderResponseDto> ordersList = new ArrayList<>();

        for (Order order : orders) {
            List<OrderProducts> orderProducts = orderProductsRepository.findByOrderId(order.getId());
            List<OrderItemsResponseDto> list = new ArrayList<>();
            for (OrderProducts op : orderProducts) {
                OrderItemsResponseDto dto = OrderItemsResponseDto.builder()
                        .id(op.getId())
                        .productId(op.getProduct().getId())
                        .productName(op.getProduct().getTitle())
                        .quantity(op.getQuantity())
                        .productPrice(op.getProduct().getPrice())
                        .rating(op.getProduct().getRating())
                        .subTotal(BigDecimal.valueOf(op.getQuantity()).multiply(op.getProduct().getPrice()))
                        .createdAt(op.getCreatedAt())
                        .updatedAt(op.getUpdatedAt())
                        .build();

                list.add(dto);
            }

            OrderResponseDto orderResponseDto = OrderResponseDto.builder().id(order.getId()).status(order.getStatus())
                    .orderItems(list).createdAt(order.getCreatedAt()).updatedAt(order.getUpdatedAt()).build();

            ordersList.add(orderResponseDto);
        }

        return ordersList;
    }
}