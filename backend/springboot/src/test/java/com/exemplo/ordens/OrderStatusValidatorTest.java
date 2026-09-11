package com.exemplo.ordens;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.exemplo.ordens.adapter.out.persistence.OrderRepository;
import com.exemplo.ordens.domain.model.OrderStatus;
import com.exemplo.ordens.usecase.InvalidStatusTransitionException;
import com.exemplo.ordens.usecase.OrderStatusValidator;

@ExtendWith(MockitoExtension.class)
class OrderStatusValidatorTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderStatusValidator orderStatusValidator;

    @Test
    void deveRetornarTrueQuandoTransicaoDeStatusForValida() {
        // Cenário
        OrderStatus currentStatus = OrderStatus.PENDING;
        OrderStatus nextStatus = OrderStatus.PROCESSING;

        // Ação
        boolean isValid = orderStatusValidator.isValidTransition(currentStatus, nextStatus);

        // Verificação
        assertTrue(isValid);
    }

    @Test
    void deveLancarExcecaoQuandoTransicaoDeStatusForInvalida() {
        OrderStatus currentStatus = OrderStatus.DELIVERED;
        OrderStatus nextStatus = OrderStatus.PENDING;

        assertThrows(InvalidStatusTransitionException.class, () -> {
            orderStatusValidator.validateTransition(currentStatus, nextStatus);
        });
    }
}