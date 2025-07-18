package com.ecom.userDetails.userDetailsMicro.kafkaservices;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CartItemsConsumer {
    @KafkaListener(topics = "cart-items", groupId = "usercart-service-group")
    public void listen(String message) {
        System.out.println("Received CartItem from Kafka: " + message);
    }
}
