package com.thewithel.dbservice.services;

import com.thewithel.dbservice.model.Author;

public interface AuthorService {
    Author findAuthorByLastName(String name);
}
