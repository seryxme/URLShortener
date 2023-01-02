package com.myurl.shortener.dtos.requests;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class GetShortURLRequest {
    @NotNull(message = "URL cannot be null.")
    @NotEmpty(message = "URL cannot be empty.")
    @URL(message = "URL is invalid.")
    String longURL;
}
