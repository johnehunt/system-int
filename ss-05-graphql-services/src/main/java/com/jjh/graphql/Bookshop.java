package com.jjh.graphql;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class Bookshop {
	private List<Book> books = new ArrayList<>();

	public Bookshop() {
		books.add(new Book("121", "Java", "Technical", "1"));
		books.add(new Book("345", "Death in the Spring", "Detective", "2"));
		books.add(new Book("987", "Henry VI", "Historical", "3"));
	}

	public List<Book> getAllBooks() {
		return this.books;
	}

	public List<Book> getBooks(int count) {
		System.out.println("BookDao.getBooks");
		return books.stream().limit(count).collect(Collectors.toList());
	}

	public List<Book> getAuthorBooks(String author) {
		System.out.println("BookDao.getAuthors");
		return books.stream().filter(b -> author.equals(b.getAuthorId())).collect(Collectors.toList());
	}

	public void saveBook(Book book) {
		System.out.println("BookDAO.saveBook(" + book + ")");
		books.add(book);
	}
}
