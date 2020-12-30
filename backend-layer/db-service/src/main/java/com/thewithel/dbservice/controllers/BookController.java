package com.thewithel.dbservice.controllers;

import com.thewithel.dbservice.DTO.AddBookDTO;
import com.thewithel.dbservice.DTO.BookDTO;
import com.thewithel.dbservice.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api", produces = "application/json;charset=UTF-8")
@Slf4j
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getBooks() {
        log.info("ENDPOINT: /getBooks() in function getBooks().");
        return ResponseEntity.ok().body(bookService.getBooks());
//        return ResponseEntity.of(bookService.getBooks());
    }

    @GetMapping("/books/add/url")
    public String addBookUrl(@RequestParam String title, @RequestParam String authorLastName,
                             @RequestParam String publisherName) {
        log.info("ENDPOINT: /books/add/url in function addBooksUrl(). With params: {}, {}, {}",
                title, authorLastName, publisherName);
        String message = bookService.addBookUrl(title, authorLastName, publisherName);
        return message;
    }

    @PostMapping("/books/add/json")
    public String addBookJson(@RequestBody AddBookDTO addBookDTO) {
        log.info("ENDPOINT: /authors/add/json in function addAuthorsJson(). With params: {}", addBookDTO.toString());
        String message = bookService.addBookJson(addBookDTO);
        return message;
    }
}
