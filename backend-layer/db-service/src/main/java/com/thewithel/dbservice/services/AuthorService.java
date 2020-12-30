package com.thewithel.dbservice.services;

import com.thewithel.dbservice.DTO.AddAuthorDTO;
import com.thewithel.dbservice.DTO.AuthorDTO;
import com.thewithel.dbservice.model.Author;

import java.util.List;

public interface AuthorService {
    Author findAuthorByLastName(String name);
    List<AuthorDTO> getAuthors();
    String addAuthorUrl(String name, String lastName);
    String addAuthorJson(AddAuthorDTO addAuthorDTO);
}
