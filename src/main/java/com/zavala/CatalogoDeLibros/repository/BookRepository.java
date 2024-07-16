package com.zavala.CatalogoDeLibros.repository;


import com.zavala.CatalogoDeLibros.model.Book;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguages(String languages);
}
