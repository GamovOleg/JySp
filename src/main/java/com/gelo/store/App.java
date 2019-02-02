package com.gelo.store;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Collections;

@SpringBootApplication
@EnableAutoConfiguration
public class App {

    public static void main(String[] args) {
        System.getProperties().put("server.port", 8181);
        SpringApplication.run(App.class, args);
    }
}
