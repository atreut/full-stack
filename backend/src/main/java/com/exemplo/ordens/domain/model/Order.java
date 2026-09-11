package com.exemplo.ordens.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Order(
    Long id,
    String customerName,
    BigDecimal amount,
    OrderStatus status,
    LocalDateTime createdAt
) {
    public Order {
        if (amount != null && amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor da ordem não pode ser negativo.");
        }
    }
}