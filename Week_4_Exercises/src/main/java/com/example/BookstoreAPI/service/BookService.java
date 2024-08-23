package com.example.BookstoreAPI.service;

import org.springframework.stereotype.Service;

import com.example.BookstoreAPI.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;



@Service
public class BookService {

    // Assume you have a BookRepository with necessary methods
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

  
}

