package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.schema.OrderProducts;

public interface OrderProductsRepository extends JpaRepository<OrderProducts, Long>{

    @Query("Select op from OrderProducts op Where op.order_id = :id")
    public List<OrderProducts> findByOrderId(Long id); 
}
