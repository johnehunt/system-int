package com.jjh.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class ServiceRegistrationServer {

    public static void main(String[] args) {
        // Should be run first
        System.out.println("Starting Registration Server");
        // Tell Spring Boot to look for registration-server.yml
        System.setProperty("spring.config.name", "registration-server");
        SpringApplication.run(ServiceRegistrationServer.class, args);
        System.out.println("Registration Server Started");
        System.out.println("\tSee - http://localhost:1111/");
    }

    @ConditionalOnMissingBean
    @Bean
    public HttpTraceRepository httpTraceRepository() {
        System.out.println("ServiceRegistrationServer.httpTraceRepository()");
        return new InMemoryHttpTraceRepository();
    }
}
