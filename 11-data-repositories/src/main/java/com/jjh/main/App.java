package com.jjh.main;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		System.out.println("Starting Bookshop setup");
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		System.out.println("Setup finished");

		BookRepository repository = context.getBean(BookRepository.class);

		Iterable<Book> books = repository.findAll();
		System.out.println("books: " + books);

		Book book = new Book("10", "Java and Spring", "John Smith", 12.55);
		repository.save(book);

		System.out.println("Check book with ISBN 10 is in database");
		Optional<Book> optionalBook = repository.findById("10");
		System.out.print(optionalBook);

		System.out.println("Delete Book just Added");
		repository.deleteById("10");

		System.out.println("Done");
	}
}