package com.orangee.athenaeum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.orangee.athenaeum")
@EntityScan("com.orangee.athenaeum.models")
public class AthenaeumApplication {

    public static void main(String[] args) {
        SpringApplication.run(AthenaeumApplication.class, args);
    }

}
