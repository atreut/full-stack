package com.exemplo.ordens;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.exemplo.ordens.adapter.out.persistence.OrderEntity;
import com.exemplo.ordens.adapter.out.persistence.OrderRepository;
import com.exemplo.ordens.domain.model.OrderStatus;

@SpringBootApplication
public class OrdensApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrdensApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(OrderRepository repository) {
        return args -> {
            OrderEntity order1 = new OrderEntity("Cliente Lote A", BigDecimal.valueOf(300.00), OrderStatus.PROCESSING, LocalDateTime.now());
            repository.save(order1);

            OrderEntity order2 = new OrderEntity("Cliente Beta", BigDecimal.valueOf(150.50), OrderStatus.PENDING, LocalDateTime.now());
            repository.save(order2);
        };
    }
}