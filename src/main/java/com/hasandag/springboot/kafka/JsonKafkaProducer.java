package com.hasandag.springboot.kafka;

import com.hasandag.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaProducer {

        private static final Logger logger = LoggerFactory.getLogger(JsonKafkaProducer.class);


    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;


        private final KafkaTemplate<String, User> kafkaTemplate;

        public JsonKafkaProducer(KafkaTemplate<String, User> kafkaTemplate) {
            this.kafkaTemplate = kafkaTemplate;
        }

        public void sendMessage(User user) {
            logger.info(String.format("#### -> Producing message -> %s", user.toString()));
            Message<User> message = MessageBuilder
                    .withPayload(user)
                    .setHeader(KafkaHeaders.TOPIC, topicJsonName)
                    .build();
            this.kafkaTemplate.send(message);
        }
}
