package com.rajuboddupalli.home.config;

import com.rajuboddupalli.home.entity.Album;
import com.rajuboddupalli.home.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rajuboddupalli.home")
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class);
    }
}
