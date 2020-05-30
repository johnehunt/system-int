package com.jjh.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class BookMutationResolver implements GraphQLMutationResolver {
	
	private Bookshop bookDao;

	@Autowired
	public BookMutationResolver(Bookshop bookDao) {
		this.bookDao = bookDao;
	}

	public Book writeBook(String isbn, String title, String category, String author) {
		System.out.println("Mutation.writeBooks(" + isbn + ")");
		Book book = new Book(isbn, title, category, author);
		bookDao.saveBook(book);
		return book;
	}
}
