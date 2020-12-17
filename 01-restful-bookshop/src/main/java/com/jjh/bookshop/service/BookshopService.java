package com.jjh.bookshop.service;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookshopService {
    public static void main(String[] args) {
        System.out.println("Starting the web application");
        SpringApplication app = new SpringApplication(BookshopService.class);
        app.setBannerMode(Banner.Mode.OFF); // Turn off the banner
        app.setLogStartupInfo(false); // stops default log info
        app.run(args);
        System.out.println("Startup complete");
        System.out.println("\thttp://localhost:8080/service/book/list");
        System.out.println("\thttp://localhost:8080/service/book/123");
    }
}
