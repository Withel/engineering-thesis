package com.thewithel.dbservice.services;

import com.thewithel.dbservice.model.Book;

public interface BookService {
    Book findBookByName(String name);
}
