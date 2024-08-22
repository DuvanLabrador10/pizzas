package com.duvanlabrador.pizza.web.controller;

import com.duvanlabrador.pizza.persistence.projections.OrderSummary;
import com.duvanlabrador.pizza.services.interfaces.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/summary/{orderId}")
    public ResponseEntity<OrderSummary> getSummary(@PathVariable Long orderId){
        return ResponseEntity.ok(this.orderService.getSummary(orderId));
    }
}
