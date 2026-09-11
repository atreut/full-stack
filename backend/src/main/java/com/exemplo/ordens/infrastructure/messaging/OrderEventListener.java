package com.exemplo.ordens.infrastructure.messaging;

import com.exemplo.ordens.infrastructure.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventListener {

    @RabbitListener(queues = RabbitMQConfig.ORDER_CREATED_QUEUE)
    public void handleOrderCreated(Object orderEvent) {
        System.out.println("Evento de pedido recebido com sucesso no RabbitMQ: " + orderEvent);
    }
}
