package com.myurl.shortener.dtos.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;

@Data
@NoArgsConstructor
public class GetLongURLResponse {
    String longURL;
}
