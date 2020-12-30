package com.thewithel.callservice.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class CallController {

    @Value("${service.url}")
    private String url;

    private RestTemplate restTemplate;

    public CallController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/call")
    public ResponseEntity<String> call(){
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }
}
