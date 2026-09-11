package com.exemplo.ordens.infrastructure.messaging;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.exemplo.ordens.adapter.out.persistence.OrderEntity;

@Component
@ConditionalOnProperty(name = "spring.rabbitmq.enabled", havingValue = "true", matchIfMissing = false)
public class OrderEventProducer {

    // RabbitTemplate desativado temporariamente pela remoção do RabbitMQ da stack.
    public void sendOrderCreatedEvent(OrderEntity order) {
        // No-op
    }
}