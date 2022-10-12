package com.jjh.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {
	
	private Bookshop bookshop;

	@Autowired
	public BookMutationResolver(Bookshop bookshop) {
		this.bookshop = bookshop;
	}

	public Book writeBook(String isbn,
						  String title,
						  String category,
						  String author) {
		System.out.println("Mutation.writeBooks(" + isbn + ")");
		Book book = new Book(isbn, title, category, author);
		bookshop.saveBook(book);
		return book;
	}
}
