package com.example.demo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dtos.OrderRequestDto;
import com.example.demo.dtos.OrderResponseDto;
import com.example.demo.schema.Order;
import com.example.demo.services.IOrderService;
import com.example.demo.utils.ApiResponse;

@Controller
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final IOrderService orderService; 

    public OrderController(IOrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderResponseDto>>> getAllOrders() {
        List<OrderResponseDto> orders = orderService.getAllOrders();

        return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(orders, "Orders fetched successfully"));
    }

    @PostMapping
    public Order createOrder() {
        throw new UnsupportedOperationException("Not implemented");
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<ApiResponse<Void>> deleteOrder(@PathVariable Long id) {
    //     orderService.deleteOrder(id);

    //     return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(null, "Order deleted successfully"));
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity<ApiResponse<OrderResponseDto>> getOrderById(@PathVariable Long id) {
    //     OrderResponseDto order = orderService.getOrderById(id);

    //     return ResponseEntity.status(HttpStatus.OK).body(ApiResponse.success(order, "Order fetched successfully"));
    // }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUserId(@PathVariable Long userId) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @GetMapping("/{id}/summary")
    public void getOrderSummary(@PathVariable Long id) {
        throw new UnsupportedOperationException("Not implemented");
    }

}
