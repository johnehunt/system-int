package com.jjh.bookshop.domain;

import java.util.StringJoiner;

public class Book {

  private String isbn;
  private String title;
  private double price;
  private Author author;
  private String publisher;

  public Book() {}

  public Book(String isbn, String title, double price, Author author, String publisher) {
    this.isbn = isbn;
    this.title = title;
    this.price = price;
    this.author = author;
    this.publisher = publisher;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
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

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Book.class.getSimpleName() + "[", "]")
      .add("isbn=" + isbn)
      .add("title='" + title + "'")
      .add("price=" + price)
      .add("author=" + author)
      .add("publisher='" + publisher + "'")
      .toString();
  }
}
