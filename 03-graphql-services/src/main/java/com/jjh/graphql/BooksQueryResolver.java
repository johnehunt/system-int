package com.jjh.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class BooksQueryResolver implements GraphQLQueryResolver {
	
	private Bookshop bookshop;

	@Autowired
	public BooksQueryResolver(Bookshop bookshop) {
		this.bookshop = bookshop;
	}

	public List<Book> getBooks(int count) {
		System.out.println("Query.getBooks(" + count + ")");
		if (count == -1) {
			return bookshop.getAllBooks();
		} else {
			return bookshop.getBooks(count);
		}
	}

	public List<Book> getAllbooks() {
		System.out.println("Query.getAllBooks()");
		return bookshop.getAllBooks();
	}
}
