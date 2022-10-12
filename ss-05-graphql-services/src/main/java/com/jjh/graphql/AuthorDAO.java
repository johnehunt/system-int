package com.jjh.graphql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class AuthorDAO {
    private List<Author> authors;

    public AuthorDAO() {
    	authors = new ArrayList<>();
		authors.add(new Author("1", "John"));
		authors.add(new Author("2", "Denise"));
		authors.add(new Author("3", "Paul"));
    }

    public Optional<Author> getAuthor(final String id) {
    	System.out.println("AuthorDao.getAuthor(" + id + ")");
        return authors.stream().filter(author -> id.equals(author.getId())).findFirst();
    }
}
