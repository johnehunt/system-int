package com.jjh.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookshopGQLApp extends SpringBootServletInitializer {

	public static void main(String[] args)  {
		System.out.println("Starting App setup");
		SpringApplication.run(BookshopGQLApp.class, args);
		System.out.println("Setup finished");
		System.out.println("Access: http://localhost:8080/graphiql");
	}


}