package com.exemplo.ordens.adapter.in.rest;

import com.exemplo.ordens.adapter.out.persistence.OrderEntity;
import com.exemplo.ordens.adapter.out.persistence.OrderRepository;
import com.exemplo.ordens.usecase.OrderStatusValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(order -> new OrderResponse(order, OrderStatusValidator.getNextStepMessage(order.getStatus())))
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> ResponseEntity.ok(new OrderResponse(order, OrderStatusValidator.getNextStepMessage(order.getStatus()))))
                .orElse(ResponseEntity.notFound().build());
    }

    public record OrderResponse(OrderEntity order, String statusMessage) {}
}