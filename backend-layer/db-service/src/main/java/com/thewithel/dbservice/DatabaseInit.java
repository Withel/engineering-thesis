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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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

    @Value("${spring.profiles.active}")
    String dataBase;

    @Override
    public void run(String... args) throws Exception {

        if(dataBase.equals("localhost")){
            // Publishers
            Publisher publisher = new Publisher();
            publisher.setAdres("1600 Amphitheatre Parkway, Mountain View, CA, 94043");
            publisher.setName("Google".toLowerCase());
            publisherRepository.save(publisher);

            publisher = new Publisher();
            publisher.setName("Microsoft".toLowerCase());
            publisher.setAdres("Redmond, Washington, United States");
            publisherRepository.save(publisher);

            // Authors
            Author author = new Author();
            author.setName("John Ronald Reuel".toLowerCase());
            author.setLastName("Tolkien".toLowerCase());
            authorRepository.save(author);

            author = new Author();
            author.setName("Terence David John".toLowerCase());
            author.setLastName("Pratchett".toLowerCase());
            authorRepository.save(author);

            // Books
            Book book = new Book();
            book.setTitle("Lord of the Rings - Return of the King".toLowerCase());
            book.setPublisher(publisherService.findPublisherByName("Google".toLowerCase()));
            book.setAuthor(authorService.findAuthorByLastName("Tolkien".toLowerCase()));
            bookRepository.save(book);

            book = new Book();
            book.setTitle("Lord of the Rings - The Fellowship of the Rings".toLowerCase());
            book.setPublisher(publisherService.findPublisherByName("Google".toLowerCase()));
            book.setAuthor(authorService.findAuthorByLastName("Tolkien".toLowerCase()));
            bookRepository.save(book);

            book = new Book();
            book.setTitle("Lord of the Rings - The Two Towers".toLowerCase());
            book.setPublisher(publisherService.findPublisherByName("Google".toLowerCase()));
            book.setAuthor(authorService.findAuthorByLastName("Tolkien".toLowerCase()));
            bookRepository.save(book);


            book = new Book();
            book.setTitle("The Colour of Magic".toLowerCase());
            book.setAuthor(authorService.findAuthorByLastName("Pratchett".toLowerCase()));
            book.setPublisher(publisherService.findPublisherByName("Microsoft".toLowerCase()));
            bookRepository.save(book);

            book = new Book();
            book.setTitle("The Light Fantastic".toLowerCase());
            book.setAuthor(authorService.findAuthorByLastName("Pratchett".toLowerCase()));
            book.setPublisher(publisherService.findPublisherByName("Microsoft".toLowerCase()));
            bookRepository.save(book);

            book = new Book();
            book.setTitle("Equal Rites".toLowerCase());
            book.setAuthor(authorService.findAuthorByLastName("Pratchett".toLowerCase()));
            book.setPublisher(publisherService.findPublisherByName("Microsoft".toLowerCase()));
            bookRepository.save(book);
        }
    }
}
