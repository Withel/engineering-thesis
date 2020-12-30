package com.thewithel.dbservice.services;

import com.thewithel.dbservice.DTO.AddBookDTO;
import com.thewithel.dbservice.DTO.BookDTO;
import com.thewithel.dbservice.model.Book;

import java.util.List;

public interface BookService {
    List<BookDTO> getBooks();
    Book findBookByName(String name);
    String addBookUrl(String title, String authorLastName, String publisherName);
    String addBookJson(AddBookDTO addBookDTO);
}
