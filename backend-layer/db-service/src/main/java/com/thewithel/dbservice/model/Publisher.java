package com.thewithel.dbservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String adres;

    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
