package com.myurl.shortener.services;

import com.myurl.shortener.data.model.URLLink;
import com.myurl.shortener.data.repositories.URLRepository;
import com.myurl.shortener.dtos.requests.GetLongURLRequest;
import com.myurl.shortener.dtos.requests.GetShortURLRequest;
import com.myurl.shortener.dtos.responses.GetLongURLResponse;
import com.myurl.shortener.dtos.responses.GetShortURLResponse;
import com.myurl.shortener.exceptions.InvalidURLExecption;
import com.myurl.shortener.utils.IDConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

@Service
public class URLServiceImpl implements URLService {

    @Autowired
    URLRepository urlRepository;

    @Override
    public GetShortURLResponse getShortURL(GetShortURLRequest getURLRequest) throws InvalidURLExecption {
        isValidURL(getURLRequest.getLongURL());
        URLLink newUrRL = new URLLink();
        newUrRL.setLink(getURLRequest.getLongURL());
        newUrRL.setId(String.valueOf(urlRepository.count()));
        urlRepository.save(newUrRL);

        String subDir = getSubDirectory(newUrRL.getId());

        GetShortURLResponse response = new GetShortURLResponse();
        response.setShortURL("localhost:8080/" + subDir);
        return response;
    }

    private String getSubDirectory(String id) {
        int requestID = Integer.parseInt(id);
        return IDConverter.convertRequestID(requestID);
    }

    private void isValidURL(String url) throws InvalidURLExecption {
        if(!url.matches("^https?:\\/\\/(?:www.)?[-a-zA-Z\\d@:%._\\+~#=]{1,256}" +
                "\\.[a-zA-Z\\d9()]{1,6}\\b(?:[-a-zA-Z\\d@:%._\\+.~#?&\\/=]*)$")) {
            throw new InvalidURLExecption("The link supplied is invalid. Please try again.");
        }
    }

    @Override
    public GetLongURLResponse getLongURL(String shortURL) {
        String id = String.valueOf(getRequestID(shortURL));

        GetLongURLResponse response = new GetLongURLResponse();
        response.setLongURL(urlRepository.findURLLinkById(id).getLink());

        return response;
    }

    private int getRequestID(String shortURL) {
        String[] compArray = shortURL.split("/");
        String subDir = compArray[compArray.length - 1];
        return IDConverter.getRequestID(subDir);
    }

    @Override
    public long numOfURLs() {
        return urlRepository.count();
    }
}
