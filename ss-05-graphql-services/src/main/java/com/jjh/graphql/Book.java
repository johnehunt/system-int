package com.jjh.graphql;

public class Book {
	private String isbn;
	private String title;
	private String category;
	private String authorId;

	public Book() {}

	public Book(String isbn, String title, String category, String authorId) {
		this.isbn = isbn;
		this.title = title;
		this.category = category;
		this.authorId = authorId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String id) {
		this.isbn = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
}
