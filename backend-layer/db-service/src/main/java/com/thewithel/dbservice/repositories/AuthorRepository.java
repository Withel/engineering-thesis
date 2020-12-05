package com.thewithel.dbservice.repositories;

import com.thewithel.dbservice.model.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    Optional<Author> findByName(String name);
    Optional<Author> findByLastName(String name);
}
