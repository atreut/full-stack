package com.exemplo.ordens.adapter.out.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAuditRepository extends MongoRepository<OrderAuditDocument, String> {
}