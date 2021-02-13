package com.project.boni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(dateTimeProviderRef = "dateTimeProvider")
public class BoniApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoniApplication.class, args);
    }

}
