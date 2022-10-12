package com.example.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.service", "com.example.demo.controller"})
public class Application {
  public static void main(String[] args) {
    System.out.println("Starting the web application");
    SpringApplication.run(Application.class, args);
    System.out.println("Startup complete");
    System.out.println("\thttp://localhost:8080/users/list");
    System.out.println("\thttp://localhost:8080/users/user/john");
  }
}
