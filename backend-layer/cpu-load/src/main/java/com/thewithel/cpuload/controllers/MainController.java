package com.thewithel.cpuload.controllers;

import com.thewithel.cpuload.services.HashService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    HashService hashService;

    public MainController(HashService hashService) {
        this.hashService = hashService;
    }

    @GetMapping("/")
    public String root(){
//        List list = new ArrayList();
//        list.add("Hello from CPU-Load!");
//        list.add("Use it by manipulating the path:");
//        return list;
        return "Hello from CPU-Load!\n" +
                "Use it by manipulating the path:\n" +
                "/name-of-algorithm/text-to-hash/number-of-times\n\n" +
                "Available algorithms: md5, sha256, sha512. Number of times is optional.";
    }

    @GetMapping("/md5/{word}")
    public String md5(@PathVariable String word){
        return hashService.hashMd5(word);
    }

    @GetMapping("/sha256/{word}")
    public String sha256(@PathVariable String word){
        return hashService.hashSha256(word);
    }

    @GetMapping("/sha512/{word}")
    public String sha512(@PathVariable String word){
        return hashService.hashSha512(word);
    }
}
