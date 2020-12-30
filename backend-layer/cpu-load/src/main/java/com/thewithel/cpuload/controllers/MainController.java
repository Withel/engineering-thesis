package com.thewithel.cpuload.controllers;

import com.thewithel.cpuload.services.HashService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
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
        return  "Hello you are using: "+ "${app.active.profile}\n" +
                "Hello from CPU-Load!\n" +
                "Use it by manipulating the path:\n" +
                "/name-of-algorithm/text-to-hash/number-of-times\n\n" +
                "Available algorithms: md5, sha256, sha512. Number of times is optional.";
    }

    @GetMapping("/callme")
    public String callMe(){
        log.info("ENDPOINT: /callme in function callMe().");
        return "Hello, you have called /callme in cpu-load application.";
    }

    @GetMapping("/md5/{word}")
    public String md5(@PathVariable String word){
        log.info("ENDPOINT: /md5/{word} in function md5. Arguments given: {}", word);
        return hashService.hashMd5(word);
    }

    @GetMapping("/sha256/{word}")
    public String sha256(@PathVariable String word){
        log.info("ENDPOINT: /sha256/{word} in function sha256(). Arguments given: {}", word);
        return hashService.hashSha256(word);
    }

    @GetMapping("/sha512/{word}")
    public String sha512(@PathVariable String word){
        log.info("ENDPOINT: /sha512/{word} in function sha512(). Arguments given: {}", word);
        return hashService.hashSha512(word);
    }

    @GetMapping("/md5/{word}/{n}")
    public String md5WithParam(@PathVariable String word, @PathVariable Long n){
        log.info("ENDPOINT: /md5/{word}/{n} in function md5WithParam(). Arguments given: {}, {}", word, n);
        return hashService.hashMd5(word, n);
    }

    @GetMapping("/sha256/{word}/{n}")
    public String sha256WithParam(@PathVariable String word, @PathVariable Long n){
        log.info("ENDPOINT: /sha256/{word}/{n} in function sha2565WithParam(). Arguments given: {}, {}", word, n);
        return hashService.hashSha256(word, n);
    }

    @GetMapping("/sha512/{word}/{n}")
    public String sha512WithParam(@PathVariable String word, @PathVariable Long n){
        log.info("ENDPOINT: /sha512/{word}/{n} in function sha512WithParam(). Arguments given: {}, {}", word, n);
        return hashService.hashSha512(word, n);
    }
}
