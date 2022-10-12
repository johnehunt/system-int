package com.jjh.bookshop.controller;

import com.jjh.bookshop.domain.Book;
import com.jjh.bookshop.domain.BookException;
import com.jjh.bookshop.service.BookshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bookshop")
public class BookshopController {
  private BookshopService bookshop;

  @Autowired
  public void setBookshop(BookshopService bookshop) {
    this.bookshop = bookshop;
  }

  @GetMapping("/book/{isbn}")
  @ResponseStatus(HttpStatus.OK)
  public Book getBook(@PathVariable String isbn) {
    System.out.println("BookshopController.getBook(" + isbn + ")");
    return this.bookshop.getBookByISBN(isbn);
  }

  @GetMapping("/book/list")
  @ResponseStatus(HttpStatus.OK)
  public List<Book> getAllBooks() {
    System.out.println("BookshopController.getAllBooks()");
    return bookshop.getBooks();
  }

  @PostMapping("/book")
  @ResponseStatus(HttpStatus.OK)
  public void addBook(@RequestBody Book book) {
    System.out.println("BookshopController.addBook(" + book + ")");
    this.bookshop.addBook(book);
  }

  @PutMapping
  @ResponseStatus(HttpStatus.OK)
  public void updateBook(@RequestBody Book book) {
    System.out.println("BookshopController.updateBook(" + book + ")");
    this.bookshop.updateBook(book);
  }

  @DeleteMapping("{title}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteBook(@PathVariable String title) {
    System.out.println("BookshopController.deleteBook(" + title + ")");
    bookshop.deleteBook(title);
  }

  @ExceptionHandler(BookException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
  public void updateFailure() { }


}
