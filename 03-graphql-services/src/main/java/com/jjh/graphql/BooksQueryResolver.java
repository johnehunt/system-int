package com.jjh.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class BooksQueryResolver implements GraphQLQueryResolver {
	
	private Bookshop bookshop;

	@Autowired
	public BooksQueryResolver(Bookshop bookDao) {
		this.bookshop = bookDao;
	}

	public List<Book> getBooks(int count) {
		System.out.println("Query.getBooks(" + count + ")");
		return bookshop.getBooks(count);
	}
}
