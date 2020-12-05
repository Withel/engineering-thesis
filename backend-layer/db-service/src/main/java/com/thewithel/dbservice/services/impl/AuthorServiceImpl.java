package com.thewithel.dbservice.services.impl;

import com.thewithel.dbservice.model.Author;
import com.thewithel.dbservice.repositories.AuthorRepository;
import com.thewithel.dbservice.services.AuthorService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author findAuthorByLastName(String name) {
        return authorRepository.findByLastName(name).orElse(new Author());
    }
}
