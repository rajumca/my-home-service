package com.rajuboddupalli.home.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.IOException;

@SpringBootApplication
@ComponentScan("com.rajuboddupalli.home")
public class Application {

    public static void main(String... args) throws IOException {

        SpringApplication.run(Application.class);

    }
}
