package com.thewithel.dbservice.model;

import com.thewithel.dbservice.DTO.AuthorDTO;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String lastName;

//    @ManyToMany(mappedBy = "authors")
//    private List<Book> books;

    @ToString.Exclude
    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public AuthorDTO convertToDTO(){
        AuthorDTO authorDTO = new AuthorDTO();
        authorDTO.setLastName(this.lastName);
        authorDTO.setName(this.name);
        authorDTO.setId(this.id);
        return authorDTO;
    }
}
