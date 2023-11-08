package com.course.strconsumer.listeners;

import com.course.strconsumer.custom.KafkaListenerCustom;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StrConsumerListener {

    @KafkaListener(groupId = "group-0",  topicPartitions = {@TopicPartition(topic = "str-topic", partitions = {"0"})}, containerFactory = "strContainerFactory")
    public void create(String message) {
        log.info("CREATED - Receive massage {}", message);
    }

    @KafkaListener(groupId = "group-0", topicPartitions = {@TopicPartition(topic = "str-topic", partitions = {"1"})}, containerFactory = "strContainerFactory")
    public void log(String message) {
        log.info("LOG - Receive massage {}", message);
    }
    @KafkaListenerCustom(groupId = "group-1")
    public void logHistory(String message) {
        log.info("LOG_HISTORY - Receive massage {}", message);
    }

    @KafkaListener(groupId = "group-2", topics = "str-topic", containerFactory = "strContainerFactory")
    public void history(String message) {
        log.info("HISTORY - Receive massage {}", message);
    }

}
