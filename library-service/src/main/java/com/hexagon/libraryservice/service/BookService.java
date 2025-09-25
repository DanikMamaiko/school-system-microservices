package com.hexagon.libraryservice.service;

import com.hexagon.libraryservice.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book create(Book book);
    Optional<Book> getById(String id);
    Optional<Book> getByIsbn(String isbn);
    List<Book> getAll();
    Book update(String id, Book book);
    void delete(String id);
}


