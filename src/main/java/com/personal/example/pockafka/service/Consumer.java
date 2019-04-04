package com.personal.example.pockafka.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.example.pockafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class Consumer {

    private ObjectMapper objectMapper;

    public Consumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "users")
    public void consume(@Payload String message, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition)
            throws IOException {
        User user = objectMapper.readValue(message, User.class);
        log.info(String.format("#### message in consumer -> %s from partition %d - User -> %s", message, partition, user));
    }

}
