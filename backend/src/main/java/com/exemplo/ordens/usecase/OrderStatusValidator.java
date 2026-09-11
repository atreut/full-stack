package com.exemplo.ordens.usecase;

import java.util.Map;
import java.util.Set;

import com.exemplo.ordens.adapter.out.persistence.OrderRepository;
import com.exemplo.ordens.domain.model.OrderStatus;

public class OrderStatusValidator {

    private static final Map<OrderStatus, Set<OrderStatus>> ALLOWED_TRANSITIONS = Map.of(
            OrderStatus.PENDING, Set.of(OrderStatus.PROCESSING, OrderStatus.CANCELLED),
            OrderStatus.PROCESSING, Set.of(OrderStatus.COMPLETED, OrderStatus.CANCELLED),
            OrderStatus.COMPLETED, Set.of(OrderStatus.DELIVERED),
            OrderStatus.DELIVERED, Set.of(),
            OrderStatus.CANCELLED, Set.of()
    );

    private final OrderRepository orderRepository;

    public OrderStatusValidator(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean isValidTransition(OrderStatus currentStatus, OrderStatus nextStatus) {
        return ALLOWED_TRANSITIONS.getOrDefault(currentStatus, Set.of()).contains(nextStatus);
    }

    public void validateTransition(OrderStatus currentStatus, OrderStatus nextStatus) {
        if (!isValidTransition(currentStatus, nextStatus)) {
            throw new InvalidStatusTransitionException(currentStatus, nextStatus);
        }
    }

    public static String getNextStepMessage(OrderStatus status) {
        return switch (status) {
            case PENDING -> "Aguardando liberação de estoque.";
            case PROCESSING -> "Ordem em separação no armazém.";
            case COMPLETED -> "Pedido finalizado, aguardando entrega.";
            case DELIVERED -> "Pedido entregue com sucesso.";
            case CANCELLED -> "Pedido cancelado pelo cliente ou sistema.";
        };
    }
}
