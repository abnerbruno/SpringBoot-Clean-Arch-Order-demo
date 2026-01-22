package com.example.demo.outbound.notification.client;

import com.example.demo.core.domain.entity.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification", url = "${demo.client.url}")
public interface NotificationOrderClient {

    @GetMapping(value = "/v1/estoque")
    boolean notificarGestaoEstoque(@RequestBody Order order);
}
