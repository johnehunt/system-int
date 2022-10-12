package com.jjh.bookshop.service;

import com.jjh.bookshop.domain.Author;
import com.jjh.bookshop.domain.Book;
import com.jjh.bookshop.domain.BookException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookshopService {
  private List<Book> books = new ArrayList<>();

  public BookshopService() {

    Author author = new Author("Pete Smith", "10 High Street");
    Book book = new Book("1", "Java Unleashed", 15.95, author, "tech. Books Ltd");
    System.out.println("Book: " + book);
    this.books.add(book);
    Book book2 = new Book("2", "Java For Professionals", 12.55, author, "Info Squared Publishing");
    System.out.println("\nBook2: " + book2);
    this.books.add(book2);

  }

  public List<Book> getBooks() {
    return this.books;
  }

  public Book getBookByISBN(String isbn) {
    System.out.println("Bookshop.getBookByISBN(" + isbn + ")");
    List<Book> books = this.books.stream().filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
      .collect(Collectors.toList());
    if (books.size() > 0)
      return books.get(0);
    else
      return null;
  }

  public Book getBookByTitle(String title) {
    System.out.println("Bookshop.getBook(" + title + ")");
    List<Book> books = this.books.stream().filter(b -> b.getTitle().equalsIgnoreCase(title))
      .collect(Collectors.toList());
    if (books.size() > 0)
      return books.get(0);
    else
      return null;
  }

  public void addBook(Book book) {
    System.out.println("Bookshop.addBook(" + book + ")");
    if (!this.books.contains(book)) {
      this.books.add(book);
    }
  }

  public void updateBook(Book newVersionOfBook) {
    System.out.println("Bookshop.updateBook(" + newVersionOfBook + ")");
    Book originalBook = this.getBookByTitle(newVersionOfBook.getTitle());
    if (originalBook == null)
      throw new BookException("Book with title: " + newVersionOfBook.getTitle() + " not found");
    originalBook.setAuthor(newVersionOfBook.getAuthor());
    originalBook.setPrice(newVersionOfBook.getPrice());
  }

  public void deleteBook(String title) {
    System.out.println("Bookshop.deleteBook(" + title + ")");
    Book book = this.getBookByTitle(title);
    if (book != null)
      this.books.remove(book);
    else
      throw new BookException("Book with title: " + title + " not found");
  }


}
