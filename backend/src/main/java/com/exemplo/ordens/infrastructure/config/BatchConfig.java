package com.exemplo.ordens.infrastructure.config;

import com.exemplo.ordens.adapter.out.persistence.OrderEntity;
import com.exemplo.ordens.adapter.out.persistence.OrderRepository;
import com.exemplo.ordens.domain.model.OrderStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.item.data.builder.RepositoryItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Map;

@Configuration
public class BatchConfig {

    @Bean
    public RepositoryItemReader<OrderEntity> reader(OrderRepository orderRepository) {
        return new RepositoryItemReaderBuilder<OrderEntity>()
                .name("orderItemReader")
                .repository(orderRepository)
                .methodName("findAll")
                .pageSize(10)
                .sorts(Map.of("id", Sort.Direction.ASC))
                .build();
    }

    @Bean
    public ItemProcessor<OrderEntity, OrderEntity> processor() {
        return item -> {
            if (item.getStatus() == OrderStatus.PENDING) {
                item.setStatus(OrderStatus.PROCESSING);
            }
            return item;
        };
    }

    @Bean
    public ItemWriter<OrderEntity> writer(OrderRepository orderRepository) {
        return items -> orderRepository.saveAll(items);
    }

    @Bean
    public Step processOrdersStep(JobRepository jobRepository, 
                                  PlatformTransactionManager transactionManager,
                                  ItemReader<OrderEntity> reader,
                                  ItemProcessor<OrderEntity, OrderEntity> processor,
                                  ItemWriter<OrderEntity> writer) {
        return new StepBuilder("processOrdersStep", jobRepository)
                .<OrderEntity, OrderEntity>chunk(5, transactionManager)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean
    public Job processOrdersJob(JobRepository jobRepository, Step processOrdersStep) {
        return new JobBuilder("processOrdersJob", jobRepository)
                .start(processOrdersStep)
                .build();
    }
}