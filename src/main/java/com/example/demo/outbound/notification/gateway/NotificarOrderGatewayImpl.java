package com.example.demo.outbound.notification.gateway;

import com.example.demo.core.domain.entity.Order;
import com.example.demo.core.gateways.NotificationOrderGateway;
import com.example.demo.outbound.notification.client.NotificationOrderClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificarOrderGatewayImpl implements NotificationOrderGateway {

    private final NotificationOrderClient notificationOrderClient;

    @Override
    public boolean notificationOrder(Order order) {
        //notificationOrderClient.notificarGestaoEstoque(order);
        return true; // Pelo client é possível realizar requisição externa
    }
}
