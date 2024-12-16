package com.example.apacke_kafka_example.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
    private Long id;
    private Long userId;
    private String title;
    private String body;
}
