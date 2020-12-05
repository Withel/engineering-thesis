package com.thewithel.dbservice.services.impl;

import com.thewithel.dbservice.model.Publisher;
import com.thewithel.dbservice.repositories.PublisherRepository;
import com.thewithel.dbservice.services.PublisherService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PublisherServiceImpl implements PublisherService{

    PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher findPublisherByName(String name) {
        return publisherRepository.findByName(name).orElse(new Publisher());
    }
}
