package com.example.demo.inbound.controllers;

import com.example.demo.inbound.dtos.OrderDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {


    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    @DisplayName("shouldCreateOrder")
    void shouldCreateOrder() {

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setClientId("CLI-001");
        orderDTO.setItemRef("ITEM-ABC123");
        orderDTO.setQuantity(2);
        orderDTO.setPrice(new BigDecimal("99.90"));
        orderDTO.setPaymentDate(LocalDateTime.now());
        orderDTO.setPaymentType("CREDIT_CARD");


        ResponseEntity<Void> voidResponseEntity = restTemplate.postForEntity("/v1/order", orderDTO, Void.class);

        Assertions.assertEquals(HttpStatus.CREATED, voidResponseEntity.getStatusCode());

    }



}