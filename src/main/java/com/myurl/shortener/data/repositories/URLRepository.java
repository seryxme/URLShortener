package com.myurl.shortener.data.repositories;

import com.myurl.shortener.data.model.URLLink;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface URLRepository extends MongoRepository<URLLink, String> {
    URLLink findURLLinkById(String id);
}
