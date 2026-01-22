package com.example.demo.inbound.controllers;

import com.example.demo.inbound.dtos.OrderDTO;
import com.example.demo.inbound.facades.OrderFacade;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/order")
public class OrderController {

    public final OrderFacade orderFacade;

    @Operation(summary = "Criar pedido", description = "Cria um novo pedido no sistema")
    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody @Valid OrderDTO orderDTO) {
        orderFacade.createOrder(orderDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Buscar pedido por ID")
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> findOrderById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(orderFacade.findById(id));
    }

}
