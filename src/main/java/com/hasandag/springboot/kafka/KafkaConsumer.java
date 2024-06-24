package com.hasandag.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

        private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

        @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
        public void consume(@Payload String message,@Header(KafkaHeaders.OFFSET) String offset) {
            logger.info(String.format("#### -> Consumed message -> %s", message));
        }
}
