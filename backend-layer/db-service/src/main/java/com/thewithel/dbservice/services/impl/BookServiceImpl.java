package com.thewithel.dbservice.services.impl;

import com.thewithel.dbservice.DTO.AddBookDTO;
import com.thewithel.dbservice.DTO.BookDTO;
import com.thewithel.dbservice.model.Author;
import com.thewithel.dbservice.model.Book;
import com.thewithel.dbservice.model.Publisher;
import com.thewithel.dbservice.repositories.BookRepository;
import com.thewithel.dbservice.services.AuthorService;
import com.thewithel.dbservice.services.BookService;
import com.thewithel.dbservice.services.PublisherService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;
    AuthorService authorService;
    PublisherService publisherService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService,
                           PublisherService publisherService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @Override
    public List<BookDTO> getBooks() {
        List<BookDTO> books = new ArrayList<>();
        bookRepository.findAll().iterator().forEachRemaining(book -> books.add(book.convertToDTO()));
        return books;
    }

    @Override
    public Book findBookByName(String name) {
        return bookRepository.findByTitle(name).orElse(null);
    }

    @Override
    public String addBookUrl(String title, String authorLastName, String publisherName) {

        Publisher publisher = publisherService.findPublisherByName(publisherName.toLowerCase());
        Author author = authorService.findAuthorByLastName(authorLastName.toLowerCase());

        if(publisher == null){
            return "no such publisher in database";
        } else if(author == null){
            return "no such author in database";
        } else {
            Book book = new Book();
            book.setTitle(title.replace('_', ' ').toLowerCase());
            book.setPublisher(publisher);
            book.setAuthor(author);
            bookRepository.save(book);
            return "acknowledged";
        }
    }

    @Override
    public String addBookJson(AddBookDTO addBookDTO) {

        if(findBookByName(addBookDTO.getTitle().toLowerCase().replace('_', ' ')) != null){
            return "name of the book must be unique";
        }

        Publisher publisher = publisherService.findPublisherByName(addBookDTO.getPublisherName().toLowerCase());
        Author author = authorService.findAuthorByLastName(addBookDTO.getAuthorLastName().toLowerCase());

        if(publisher == null){
            return "no such publisher in database";
        } else if(author == null){
            return "no such author in database";
        } else {
            Book book = new Book();
            book.setTitle(addBookDTO.getTitle().replace('_', ' ').toLowerCase());
            book.setPublisher(publisher);
            book.setAuthor(author);
            bookRepository.save(book);
            return "acknowledged";
        }
    }
}
