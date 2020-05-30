package com.jjh.graphql;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.kickstart.tools.GraphQLResolver;

@Component
public class AuthorForBookResolver implements GraphQLResolver<Book> {
	private AuthorDAO authorDao;

	@Autowired
	public AuthorForBookResolver(AuthorDAO authorDao) {
		this.authorDao = authorDao;
	}

	public Optional<Author> getAuthor(Book book) {
		System.out.println("BookQueryResolver.getAuthor(" + book + ")");
		return authorDao.getAuthor(book.getAuthorId());
	}
}
