package com.akulnews.parsnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ParsnewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParsnewsApplication.class, args);
    }
}
