package com.zavala.CatalogoDeLibros.repository;

import com.zavala.CatalogoDeLibros.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByBirthYearBeforeAndDeathYearAfter(int birthYear, int deathYear);
}

