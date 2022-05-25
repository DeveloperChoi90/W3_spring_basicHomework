package com.sparta.memoprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class MemoPracApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemoPracApplication.class, args);
    }

}
