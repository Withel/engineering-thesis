package com.thewithel.dbservice.model;

import com.thewithel.dbservice.DTO.BookDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

//    @ManyToMany
//    @JoinTable(name = "book_author",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "author_id"))
//    private List<Author> authors;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    public BookDTO convertToDTO(){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(this.id);
        bookDTO.setTitle(this.title);
        return bookDTO;
    }
}
