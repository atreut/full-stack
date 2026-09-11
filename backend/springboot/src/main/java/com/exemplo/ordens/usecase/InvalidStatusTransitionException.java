package com.exemplo.ordens.usecase;

import com.exemplo.ordens.domain.model.OrderStatus;

public class InvalidStatusTransitionException extends RuntimeException {

    public InvalidStatusTransitionException(OrderStatus currentStatus, OrderStatus nextStatus) {
        super("Transição de status inválida: " + currentStatus + " -> " + nextStatus);
    }
}
