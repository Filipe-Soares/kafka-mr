package com.course.strconsumer.custom;

import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@KafkaListener
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface KafkaListenerCustom {
    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default "str-topic";
    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default "strContainerFactory";
    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default "";
}
