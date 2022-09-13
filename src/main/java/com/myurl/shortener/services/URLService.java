package com.myurl.shortener.services;

import com.myurl.shortener.dtos.requests.GetLongURLRequest;
import com.myurl.shortener.dtos.requests.GetShortURLRequest;
import com.myurl.shortener.dtos.responses.GetLongURLResponse;
import com.myurl.shortener.dtos.responses.GetShortURLResponse;
import com.myurl.shortener.exceptions.InvalidURLExecption;

public interface URLService {
    GetShortURLResponse getShortURL(GetShortURLRequest getURLRequest) throws InvalidURLExecption;

    GetLongURLResponse getLongURL(String shortUrl);

    long numOfURLs();
}
