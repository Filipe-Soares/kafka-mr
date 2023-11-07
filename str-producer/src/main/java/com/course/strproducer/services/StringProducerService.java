package com.course.strproducer.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Log4j2
@RequiredArgsConstructor
@Service
public class StringProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("str-topic", message);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[" + message +"] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
               log.error("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
        });
    }
}
