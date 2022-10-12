package com.jjh.main;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	private String isbn;
	private String author;
	private String title;
	private double price;
	
	public Book() {}
	
	public Book(String isbn, String author, String title, double price) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getISBN() {
		return isbn;
	}
	
	public void setISBN(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return String.format("Book [id=%s, author=%s, title=%s, price=%s]", isbn, author, title, price);
	}
	
}
