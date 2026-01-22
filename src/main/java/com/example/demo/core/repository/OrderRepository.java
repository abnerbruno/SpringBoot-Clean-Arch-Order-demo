package com.example.demo.core.repository;

import com.example.demo.core.domain.entity.Order;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order order);

    Optional<Order> findById(Long id);
}
