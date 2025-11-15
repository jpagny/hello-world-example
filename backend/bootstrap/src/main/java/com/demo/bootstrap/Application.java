package com.demo.bootstrap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.demo")
@EnableJpaRepositories(basePackages = "com.demo.external")
@EntityScan(basePackages = "com.demo.external")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
