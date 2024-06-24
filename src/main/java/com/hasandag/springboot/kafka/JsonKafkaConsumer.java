package com.hasandag.springboot.kafka;

import com.hasandag.springboot.payload.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {

        private static final Logger logger = LoggerFactory.getLogger(JsonKafkaConsumer.class);

        @KafkaListener(topics = "${spring.kafka.topic-json.name}", groupId = "${spring.kafka.consumer.group-id}")
        public void consume(@Payload User user) {
            logger.info(String.format("#### -> Json message received -> %s", user.toString()));
        }
}
