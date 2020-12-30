package com.thewithel.dbservice.services.impl;

import com.thewithel.dbservice.DTO.AddAuthorDTO;
import com.thewithel.dbservice.DTO.AuthorDTO;
import com.thewithel.dbservice.model.Author;
import com.thewithel.dbservice.repositories.AuthorRepository;
import com.thewithel.dbservice.services.AuthorService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class AuthorServiceImpl implements AuthorService {

    AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDTO> getAuthors() {
        List<AuthorDTO> authors = new ArrayList<>();
        authorRepository.findAll().iterator().forEachRemaining(author -> authors.add(author.convertToDTO()));
        return authors;
    }

    @Override
    public Author findAuthorByLastName(String name) {
        return authorRepository.findByLastName(name).orElse(null);
    }

    @Override
    public String addAuthorUrl(String name, String lastName) {

        if(name == null || lastName == null){
            return "one of attributes is null";
        }

        if(findAuthorByLastName(lastName.toLowerCase()) != null){
            return "author's last name must be unique";
        }

        Author author = new Author();
        author.setName(name.replace('_', ' ').toLowerCase());
        author.setLastName(lastName.replace('_', ' ').toLowerCase());

        authorRepository.save(author);

        return "acknowledged";
    }

    @Override
    public String addAuthorJson(AddAuthorDTO addAuthorDTO) {

        if(findAuthorByLastName(addAuthorDTO.getLastName().toLowerCase()) != null){
            return "author's last name must be unique";
        }

        Author author = new Author();
        author.setName(addAuthorDTO.getName().replace('_', ' ').toLowerCase());
        author.setLastName(addAuthorDTO.getLastName().replace('_', ' ').toLowerCase());

        authorRepository.save(author);

        return "acknowledged";
    }
}
