package com.thewithel.dbservice.model;

import com.thewithel.dbservice.DTO.PublisherDTO;
import lombok.Data;
import lombok.ToString;

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

    @ToString.Exclude
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    public PublisherDTO convertToDTO(){
        PublisherDTO publisherDTO = new PublisherDTO();
        publisherDTO.setId(this.id);
        publisherDTO.setAdres(this.adres);
        publisherDTO.setName(this.name);
        return publisherDTO;
    }
}
