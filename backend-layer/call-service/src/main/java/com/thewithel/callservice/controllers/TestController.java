package com.thewithel.callservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello from Call-Service";
    }

    @GetMapping("/exit")
    public void exit(){
        System.exit(0);
    }
}
