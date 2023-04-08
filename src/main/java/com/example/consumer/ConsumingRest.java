package com.example.consumer;

import com.example.consumingrest.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRest {
    public static final Logger logger = LoggerFactory.getLogger(ConsumingRest.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRest.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        return args -> {
            Student student= restTemplate.getForObject(
                    "http://localhost:8080/student", Student.class
            );
            logger.info(student.toString());
        };
    }

}
