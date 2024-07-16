package com.zavala.CatalogoDeLibros.controller;

import com.zavala.CatalogoDeLibros.model.Author;
import com.zavala.CatalogoDeLibros.model.Book;
import com.zavala.CatalogoDeLibros.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/search")
    public Book searchBook(@RequestParam String title) throws IOException, InterruptedException {
        return bookService.searchAndSaveBook(title);
    }

    @GetMapping
    public List<Book> listAllBooks() {
        return bookService.listAllBooks();
    }

    @GetMapping("/authors")
    public List<Author> listAuthors() {
        return bookService.listAuthors();
    }

    @GetMapping("/authors/alive")
    public List<Author> listAuthorsAliveInYear(@RequestParam int year) {
        return bookService.listAuthorsAliveInYear(year);
    }
}
