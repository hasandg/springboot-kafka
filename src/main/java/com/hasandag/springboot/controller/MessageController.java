package com.hasandag.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hasandag.springboot.kafka.KafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaProducer producer;

    public MessageController(KafkaProducer producer) {
        this.producer = producer;
    }

    // http://localhost:4444/api/v1/kafka/publish?message=HelloWorld
    @GetMapping(value = "/publish")
    public ResponseEntity<String> publish(@RequestParam("message") String message) {
        producer.sendMessage(message);
        return ResponseEntity.ok("Message published successfully");
    }
}
