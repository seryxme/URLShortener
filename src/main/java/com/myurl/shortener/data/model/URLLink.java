package com.myurl.shortener.data.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("URL links")
public class URLLink {

    @Id
    String id;
    String link;
}
