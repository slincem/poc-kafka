package com.personal.example.pockafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.example.pockafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Producer {

    private static final String TOPIC = "users";

    private KafkaTemplate<String, String> kafkaTemplate;
    private ObjectMapper objectMapper;

    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    @Scheduled(fixedDelay = 2000)
    public void sendMessage() throws JsonProcessingException {
        log.info("Sending message...");
        kafkaTemplate.send(TOPIC, objectMapper.writeValueAsString(new User("Santiago", 22)));
    }
}
