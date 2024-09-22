package com.hexagon.schoolservice.service.consumer;

import com.hexagon.schoolservice.service.CanteenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class Consumer {

//    @Value("${topic.name}")
//    private String orderTopic;

    private final CanteenService canteenService;

    @KafkaListener(topics = "canteen.topic")
    public void consumeMessage(Integer message) {

        log.info("message consumed: {}", message);

        canteenService.incrementRevenue(message);
    }
}
