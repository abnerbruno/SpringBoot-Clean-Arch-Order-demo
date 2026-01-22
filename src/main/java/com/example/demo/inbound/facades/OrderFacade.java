package com.example.demo.inbound.facades;

import com.example.demo.core.domain.entity.Order;
import com.example.demo.core.services.OrderService;
import com.example.demo.inbound.dtos.OrderDTO;
import com.example.demo.inbound.mappers.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderFacade {

    private final OrderService orderService;

    private final OrderMapper orderMapper;

    public void createOrder(OrderDTO orderDTO) {
        orderService.createOrder(orderMapper.toOrder(orderDTO));
    }

    public OrderDTO findById(Long id) {
        Order byId = orderService.findById(id);
        return orderMapper.toOrderDTO(byId);

    }
}
