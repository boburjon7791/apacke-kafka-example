package com.example.apacke_kafka_example;

import com.example.apacke_kafka_example.config.KafkaUtils;
import com.example.apacke_kafka_example.model.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.stream.IntStream;

@SpringBootApplication
public class ApackeKafkaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApackeKafkaExampleApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(KafkaTemplate<String, Post> kafkaTemplate){
		return args -> {
			IntStream.range(0,1000).forEach(value ->
					kafkaTemplate.send(KafkaUtils.MY_TOPIC, new Post(Long.valueOf(value), Long.valueOf(value+1), "title "+value, "body "+value)));
		};
	}

}
