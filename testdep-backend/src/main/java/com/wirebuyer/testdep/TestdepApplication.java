package com.wirebuyer.testdep;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestdepApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestdepApplication.class, args);
    }

    @Bean
    public CommandLineRunner ensureSeedData(MessageRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Message m = new Message("default message");
                repository.save(m);
            }
        };
    }

}
