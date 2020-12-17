package com.jjh.bookshop.domain;

import java.util.ArrayList;
import java.util.List;

public class Bookshop {
    private List<Book> books = new ArrayList<>();

    public Bookshop() {
        setup();
    }

    private void setup() {
        books.add(new Book("123", "Java in the Wild", "Gryff Jones", 12.55));
        books.add(new Book("124", "Enterprise Java", "Phoebe Smith", 14.55));
        books.add(new Book("125", "Android Java", "Adam Byrne", 13.99));
        books.add(new Book("126", "Java for Python Programmers", "Jasmine Davies", 10.55));
    }

    public List<Book> getAllBooks() {
        return this.books;
    }

    public Book getBookByISBN(String isbn) {
        System.out.println("Bookshop.getBook(" + isbn + ")");
        Book book = this.books
                        .stream()
                        .filter(b -> b.getIsbn().equalsIgnoreCase(isbn))
                        .findFirst()
                        .orElse(null);
        if (book == null) {
            throw new BookNotFoundException("Missing Book");
        }
        return book;
    }

    public void addBook(Book book) {
        System.out.println("Bookshop.addBook(" + book + ")");
        if (!this.books.contains(book)) {
            this.books.add(book);
        }
    }

    public void updateBook(Book newVersionOfBook) {
        System.out.println("Bookshop.updateBook(" + newVersionOfBook + ")");
        Book originalBook = this.getBookByISBN(newVersionOfBook.getIsbn());
        if (originalBook == null)
            throw new BookNotFoundException("Book with isbn: " + newVersionOfBook.getIsbn() + " not found");
        originalBook.setAuthor(newVersionOfBook.getAuthor());
        originalBook.setPrice(newVersionOfBook.getPrice());
    }

    public void deleteBook(String isbn) {
        System.out.println("Bookshop.deleteBook(" + isbn + ")");
        Book book = this.getBookByISBN(isbn);
        if (book != null)
            this.books.remove(book);
        else
            throw new BookNotFoundException("Book with isbn: " + isbn + " not found");
    }

}
