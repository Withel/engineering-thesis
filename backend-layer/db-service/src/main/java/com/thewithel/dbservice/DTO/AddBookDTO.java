package com.thewithel.dbservice.DTO;

import lombok.Data;

@Data
public class AddBookDTO {

    private String title;
    private String publisherName;
    private String authorLastName;
}
