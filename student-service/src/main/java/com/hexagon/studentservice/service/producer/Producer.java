package com.hexagon.studentservice.service.producer;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Producer {

    @Value("${topic.name}")
    private String orderTopic;

    private final KafkaTemplate<String, Integer> kafkaTemplate;

    public String sendMessage(Integer foodPrice) {
        log.info("Sending Message to Topic {}", orderTopic);
        String topic = orderTopic;
        kafkaTemplate.send(topic, foodPrice);

        log.info("food price: {}", foodPrice);

        return "message sent";
    }
}
