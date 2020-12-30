package com.thewithel.dbservice.services.impl;

import com.thewithel.dbservice.DTO.AddPublisherDTO;
import com.thewithel.dbservice.DTO.PublisherDTO;
import com.thewithel.dbservice.model.Publisher;
import com.thewithel.dbservice.repositories.PublisherRepository;
import com.thewithel.dbservice.services.PublisherService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class PublisherServiceImpl implements PublisherService{

    PublisherRepository publisherRepository;

    public PublisherServiceImpl(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Publisher findPublisherByName(String name) {
        return publisherRepository.findByName(name).orElse(null);
    }

    @Override
    public List<PublisherDTO> getPublishers() {
        List<PublisherDTO> publishers = new ArrayList<>();
        publisherRepository.findAll().iterator().forEachRemaining(publisher -> publishers.add(publisher.convertToDTO()));
        return publishers;
    }

    @Override
    public String addPublisherUrl(String name, String address) {

        if(findPublisherByName(name.toLowerCase()) != null){
            return "publisher name has to be uniqe";
        }

        Publisher publisher = new Publisher();
        publisher.setName(name.replace('_', ' ').toLowerCase());
        publisher.setAdres(address.replace('_', ' ').toLowerCase());

        publisherRepository.save(publisher);

        return "acknowledged";
    }

    @Override
    public String addPublisherJson(AddPublisherDTO addPublisherDTO) {

        if(addPublisherDTO.getName() == null || addPublisherDTO.getAddress() == null){
            return "one of the attributes is null";
        }

        if(findPublisherByName(addPublisherDTO.getName().toLowerCase()) != null){
            return "publisher name has to be uniqe";
        }

        Publisher publisher = new Publisher();
        publisher.setName(addPublisherDTO.getName().replace('_', ' ').toLowerCase());
        publisher.setAdres(addPublisherDTO.getAddress().replace('_', ' ').toLowerCase());

        publisherRepository.save(publisher);

        return "acknowledged";
    }
}
