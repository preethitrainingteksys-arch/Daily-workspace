package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBasicsApplication {



    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBasicsApplication.class, args);
        
     
        NoteService service = context.getBean(NoteService.class);
        System.out.println("Fetched Service: " + service);
    }
}