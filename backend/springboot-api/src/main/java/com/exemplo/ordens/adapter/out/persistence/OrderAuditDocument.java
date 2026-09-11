package com.exemplo.ordens.adapter.out.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "order_audit")
public class OrderAuditDocument {

    @Id
    private String id;
    private Long orderId;
    private String action;
    private LocalDateTime timestamp;

    public OrderAuditDocument(Long orderId, String action) {
        this.orderId = orderId;
        this.action = action;
        this.timestamp = LocalDateTime.now();
    }

    // Getters e Setters
    public String getId() { return id; }
    public Long getOrderId() { return orderId; }
    public String getAction() { return action; }
    public LocalDateTime getTimestamp() { return timestamp; }
}