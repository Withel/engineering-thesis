package com.thewithel.dbservice;

import com.thewithel.dbservice.model.Author;
import com.thewithel.dbservice.model.Book;
import com.thewithel.dbservice.model.Publisher;
import com.thewithel.dbservice.repositories.AuthorRepository;
import com.thewithel.dbservice.repositories.BookRepository;
import com.thewithel.dbservice.repositories.PublisherRepository;
import com.thewithel.dbservice.services.AuthorService;
import com.thewithel.dbservice.services.BookService;
import com.thewithel.dbservice.services.PublisherService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseInit implements CommandLineRunner {

    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    private BookService bookService;
    private AuthorService authorService;
    private PublisherService publisherService;

    public DatabaseInit(BookRepository bookRepository, AuthorRepository authorRepository,
                        PublisherRepository publisherRepository, BookService bookService,
                        AuthorService authorService, PublisherService publisherService) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }

    @Override
    public void run(String... args) throws Exception {

        // Publishers
        Publisher publisher = new Publisher();
        publisher.setAdres("1600 Amphitheatre Parkway, Mountain View, CA, 94043");
        publisher.setName("Google");
        publisherRepository.save(publisher);

        publisher = new Publisher();
        publisher.setName("Microsoft");
        publisher.setAdres("Redmond, Washington, United States");
        publisherRepository.save(publisher);

        // Authors
        Author author = new Author();
        author.setName("John Ronald Reuel");
        author.setLastName("Tolkien");
        authorRepository.save(author);

        author = new Author();
        author.setName("Terence David John");
        author.setLastName("Pratchett");
        authorRepository.save(author);

        // Books
        Book book = new Book();
        book.setName("Lord of the Rings - Return of the King");
        book.setPublisher(publisherService.findPublisherByName("Google"));
        List<Author> tempList = new ArrayList<>();
        tempList.add(authorService.findAuthorByLastName("Tolkien"));
        book.setAuthors(tempList);
        bookRepository.save(book);

        book = new Book();
        book.setName("Lord of the Rings - The Fellowship of the Rings");
        book.setPublisher(publisherService.findPublisherByName("Google"));
        book.setAuthors(tempList);
        bookRepository.save(book);

        book = new Book();
        book.setName("Lord of the Rings - The Two Towers");
        book.setPublisher(publisherService.findPublisherByName("Google"));
        book.setAuthors(tempList);
        bookRepository.save(book);

        tempList.clear();
        tempList.add(authorService.findAuthorByLastName("Pratchett"));
        book = new Book();
        book.setName("The Colour of Magic");
        book.setAuthors(tempList);
        book.setPublisher(publisherService.findPublisherByName("Microsoft"));
        bookRepository.save(book);

        book = new Book();
        book.setName("The Light Fantastic");
        book.setAuthors(tempList);
        book.setPublisher(publisherService.findPublisherByName("Microsoft"));
        bookRepository.save(book);

        book = new Book();
        book.setName("Equal Rites");
        book.setAuthors(tempList);
        book.setPublisher(publisherService.findPublisherByName("Microsoft"));
        bookRepository.save(book);
    }
}
