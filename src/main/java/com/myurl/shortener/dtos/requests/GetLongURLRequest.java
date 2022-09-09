package com.myurl.shortener.dtos.requests;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetLongURLRequest {
    String shortURL;
}
