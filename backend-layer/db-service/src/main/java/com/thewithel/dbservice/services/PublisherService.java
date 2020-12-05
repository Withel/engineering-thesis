package com.thewithel.dbservice.services;

import com.thewithel.dbservice.model.Publisher;

public interface PublisherService {
    Publisher findPublisherByName(String name);
}
