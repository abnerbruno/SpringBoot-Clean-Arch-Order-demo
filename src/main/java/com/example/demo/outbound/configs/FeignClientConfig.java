package com.example.demo.outbound.configs;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.example.demo.outbound.notification.client"})
public class FeignClientConfig {
}
