package com.colak.springtutorial.controller;

import com.colak.springtutorial.consumer.Consumer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    // http://localhost:8080/produce-order
    @GetMapping("/produce-order")
    public void produceOrder() {
        kafkaTemplate.send(Consumer.TOPIC_NAME, "Monitor, 300");
    }
}