package com.khoders.smartchurch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.khoders.*"})
@EntityScan(basePackages = {"com.khoders.*"})
@EnableJpaRepositories(basePackages = {"com.khoders.*"})
public class SmartchurchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartchurchApplication.class, args);
    }
}
