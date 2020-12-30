package com.thewithel.dbservice.controllers;

import com.thewithel.dbservice.DTO.AddAuthorDTO;
import com.thewithel.dbservice.DTO.AuthorDTO;
import com.thewithel.dbservice.services.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/api", produces = "application/json;charset=UTF-8")
@Slf4j
public class AuthorController {

    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    List<AuthorDTO> getAuthors(){
        log.info("ENDPOINT: /authors in function getAuthors().");
        return authorService.getAuthors();
    }

    @GetMapping("/authors/add/url")
    String addAuthorsUrl(@RequestParam String name, @RequestParam String lastName){
        log.info("ENDPOINT: /authors/add/url in function addAuthorsUrl(). With params: {}, {}", name, lastName);
        String message = authorService.addAuthorUrl(name, lastName);
        return message;
    }

    @PostMapping("/authors/add/json")
    String addAuthorsJson(@RequestBody AddAuthorDTO addAuthorDTO){
        log.info("ENDPOINT: /authors/add/json in function addAuthorsJson(). With param: {}", addAuthorDTO.toString());
        String message = authorService.addAuthorJson(addAuthorDTO);
        return message;
    }
}
