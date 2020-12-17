package com.jjh.bookshop.service;


import com.jjh.bookshop.domain.Book;
import com.jjh.bookshop.domain.BookNotFoundException;
import com.jjh.bookshop.domain.Bookshop;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service/book")
public class BookshopController {

    private Bookshop bookshop = new Bookshop();

    // GET Request http://localhost:8080/service/book/123

    @GetMapping("{isbn}")
    public Book getBook(@PathVariable String isbn) {
        System.out.println("IS BookshopController.getBook(" + isbn + ")");
        Book book = this.bookshop.getBookByISBN(isbn);
        return book;
    }

    @GetMapping("list")
    public List<Book> getAllBooks() {
        System.out.println("BookshopController.getAllBooks()");
        return bookshop.getAllBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addBook(@RequestBody Book book) {
        System.out.println("BookshopController.addBook(" + book + ")");
        this.bookshop.addBook(book);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateBook(@RequestBody Book book) {
        System.out.println("BookshopController.updateBook(" + book + ")");
        this.bookshop.updateBook(book);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteBook(@PathVariable String isbn) {
        System.out.println("BookshopController.deleteBook(" + isbn + ")");
        bookshop.deleteBook(isbn);
    }

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Book not found")
    public void updateFailure() { }



}
