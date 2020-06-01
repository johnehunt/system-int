package com.jjh.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class AuthorQueryResolver implements GraphQLResolver<Author> {
	private Bookshop bookshop;

	@Autowired
	public AuthorQueryResolver(Bookshop bookshop) {
		this.bookshop = bookshop;
	}

	public List<Book> getBooks(Author author) {
		System.out.println("AuthorResolver.getBooks(" + author + ")");
		return bookshop.getAuthorBooks(author.getId());
	}
}