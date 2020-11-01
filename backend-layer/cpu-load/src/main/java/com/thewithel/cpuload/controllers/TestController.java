package com.thewithel.cpuload.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "Hello from CPU-Load!";
    }

    @GetMapping("/exit")
    public void exit(){
        System.exit(0);
    }
}
