package com.orangee.athenaeum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.orangee.athenaeum")
@EnableJpaRepositories("com.orangee.athenaeum.models.dao")
@EntityScan("com.orangee.athenaeum.models")
public class AthenaeumApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaeumApplication.class, args);
    }
}
