package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dtos.OrderRequestDto;
import com.example.demo.dtos.OrderResponseDto;
import com.example.demo.services.IOrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final IOrderService orderService; 

    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }

    // @PostMapping("/create")
    // OrderResponseDto createOrder(OrderRequestDto orderRequestDto){
    //     return this.orderService.createOrder(orderRequestDto); 
    // }
}
