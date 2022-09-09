package com.myurl.shortener.dtos.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetShortURLResponse {
    String shortURL;
}
