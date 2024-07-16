package com.zavala.CatalogoDeLibros.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.zavala.CatalogoDeLibros.dto.BookDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GutendexResponse {
    @JsonProperty("results")
    private List<BookDTO> books;

    public List<BookDTO> getBooks() {
        return books;
    }

    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}

