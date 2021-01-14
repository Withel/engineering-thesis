package com.thewithel.dbservice.controllers;

import com.thewithel.dbservice.DTO.AddPublisherDTO;
import com.thewithel.dbservice.DTO.PublisherDTO;
import com.thewithel.dbservice.services.PublisherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class PublisherController {

    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/publishers")
    List<PublisherDTO> getPublishers(){
        log.info("ENDPOINT: /publishers in function getPublishers().");
        return publisherService.getPublishers();
    }

    @GetMapping("/publishers/add/url")
    String addPublishersUrl(@RequestParam String name, @RequestParam String address){
        log.info("ENDPOINT: /publishers/add/url in function addPublishersUrl(). With params: {}, {}", name, address);
        String message = publisherService.addPublisherUrl(name, address);
        return message;
    }

    @PostMapping("/publishers/add/json")
    String addPublishersJson(@RequestBody AddPublisherDTO addPublisherDTO){
        log.info("ENDPOINT: /publishers/add/json in function addPublishersJson(). With params: {}", addPublisherDTO.toString());
        String message = publisherService.addPublisherJson(addPublisherDTO);
        return message;
    }
}
