package com.thewithel.dbservice.services.impl;

import com.thewithel.dbservice.model.Book;
import com.thewithel.dbservice.repositories.BookRepository;
import com.thewithel.dbservice.services.BookService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book findBookByName(String name) {
        return bookRepository.findByName(name).orElse(new Book());
    }
}
