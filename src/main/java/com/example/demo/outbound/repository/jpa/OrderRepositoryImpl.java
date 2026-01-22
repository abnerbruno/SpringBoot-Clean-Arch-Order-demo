package com.example.demo.outbound.repository.jpa;

import com.example.demo.core.domain.entity.Order;
import com.example.demo.core.repository.OrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepositoryImpl extends JpaRepository<Order, Long>, OrderRepository {
}
