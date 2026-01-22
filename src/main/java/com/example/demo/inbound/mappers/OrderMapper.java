package com.example.demo.inbound.mappers;

import com.example.demo.core.domain.entity.Order;
import com.example.demo.inbound.dtos.OrderDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {


    Order toOrder(OrderDTO orderDTO);

    OrderDTO toOrderDTO(Order order);
}
