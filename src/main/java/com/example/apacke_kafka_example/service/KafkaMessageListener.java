package com.example.apacke_kafka_example.service;

import com.example.apacke_kafka_example.config.KafkaUtils;
import com.example.apacke_kafka_example.model.Post;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageListener {
    private static final ObjectMapper objectMapper=new ObjectMapper();
    @KafkaListener(topics = KafkaUtils.MY_TOPIC, groupId = "${spring.kafka.consumer.group-id}")
    public void listener1(String data){
        System.out.println("data listened by 1 = " + toPost(data));
    }

    // this listener never can not listen any messages
    @KafkaListener(topics = KafkaUtils.MY_TOPIC, groupId = "${spring.kafka.consumer.group-id}")
    public void listener2(String data){
        System.out.println("data listened by 2 = " + data);
    }

    @SneakyThrows
    public static Post toPost(String data){
        return objectMapper.readValue(data, Post.class);
    }
}
