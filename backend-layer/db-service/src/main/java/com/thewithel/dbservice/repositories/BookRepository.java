package com.thewithel.dbservice.repositories;

import com.thewithel.dbservice.model.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Long> {
    Optional<Book> findByName(String name);
}
