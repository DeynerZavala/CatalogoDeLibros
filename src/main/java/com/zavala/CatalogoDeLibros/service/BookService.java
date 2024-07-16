package com.zavala.CatalogoDeLibros.service;

import com.zavala.CatalogoDeLibros.dto.BookDTO;
import com.zavala.CatalogoDeLibros.model.Author;
import com.zavala.CatalogoDeLibros.model.Book;
import com.zavala.CatalogoDeLibros.repository.AuthorRepository;
import com.zavala.CatalogoDeLibros.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GutendexClient gutendexClient;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, GutendexClient gutendexClient) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.gutendexClient = gutendexClient;
    }

    public Book searchAndSaveBook(String title) throws IOException, InterruptedException {
        GutendexResponse response = gutendexClient.searchBooks(title);
        if (response.getBooks().isEmpty()) {
            return null;
        }

        BookDTO bookDTO = response.getBooks().get(0);
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setLanguages(bookDTO.getLanguages().get(0));  // Consideramos solo el primer idioma
        book.setDownloadCount(bookDTO.getDownloadCount());

        List<Author> authors = bookDTO.getAuthors().stream().map(authorDTO -> {
            Author author = new Author();
            author.setName(authorDTO.getName());
            author.setBirthYear(authorDTO.getBirthYear());
            author.setDeathYear(authorDTO.getDeathYear());
            author.setBook(book);
            return author;
        }).collect(Collectors.toList());

        book.setAuthors(authors);
        bookRepository.save(book);
        return book;
    }

    public List<Book> listAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> listAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> listAuthorsAliveInYear(int year) {
        return authorRepository.findByBirthYearBeforeAndDeathYearAfter(year, year);
    }
}
