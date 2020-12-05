package com.thewithel.dbservice.controllers;

import com.thewithel.dbservice.DTO.BookDTO;
import com.thewithel.dbservice.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/books/add")
    public String addBook(@RequestBody BookDTO bookDTO){
        return "sasd";
    }

    @PostMapping("/books/add/")
    public String addBook

    @GetMapping("/books/add")
    public List<String> addBookGet(){
        List<String> info = new ArrayList<>();
        info.add("To get adresses do this:");
        info.add("This 1");
        info.add("This 2");
        return info;
    }



//    @GetMapping("/test")
//    public InfoDTO returnTest(){
//        InfoDTO infoDTO = new InfoDTO();
//        infoDTO.setOne("Info one");
//        infoDTO.setTwo("Infor Two");
//        return  infoDTO;
//    }
//
//    @GetMapping("/test2")
//    public List<InfoDTO> returnTest2(){
//        InfoDTO infoDTO = new InfoDTO();
//        infoDTO.setOne("Info one");
//        infoDTO.setTwo("Infor Two");
//        List<InfoDTO> info = new ArrayList<>();
//        info.add(infoDTO);
//        info.add(infoDTO);
//        return info;
//    }
}
