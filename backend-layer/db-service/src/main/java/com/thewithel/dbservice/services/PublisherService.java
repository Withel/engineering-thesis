package com.thewithel.dbservice.services;

import com.thewithel.dbservice.DTO.AddPublisherDTO;
import com.thewithel.dbservice.DTO.PublisherDTO;
import com.thewithel.dbservice.model.Publisher;

import java.util.List;

public interface PublisherService {
    Publisher findPublisherByName(String name);
    List<PublisherDTO> getPublishers();
    String addPublisherUrl(String name, String address);
    String addPublisherJson(AddPublisherDTO addPublisherDTO);
}
