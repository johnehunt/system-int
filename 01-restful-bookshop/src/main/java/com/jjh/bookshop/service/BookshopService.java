package com.jjh.bookshop.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookshopService {
    public static void main(String[] args) {
        System.out.println("Starting the web application");
        SpringApplication.run(BookshopService.class, args);
        System.out.println("Startup complete");
        System.out.println("\thttp://localhost:8080/bookshop/list");
        System.out.println("\thttp://localhost:8080/bookshop/123");
    }
}
