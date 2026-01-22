package com.example.demo.core.services;

import com.example.demo.core.domain.entity.Order;
import com.example.demo.core.domain.enums.ORDER_STATUS;
import com.example.demo.core.exceptions.DomainException;
import com.example.demo.core.gateways.NotificationOrderGateway;
import com.example.demo.core.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final NotificationOrderGateway notificationOrderGateway;

    public void createOrder(Order order) {
        order.setStatus(ORDER_STATUS.NEW);
        Order save = orderRepository.save(order);
        notificationOrderGateway.notificationOrder(save);
        log.info("Order Created {}", save);
    }

    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(DomainException::orderNotFund);
    }
}
