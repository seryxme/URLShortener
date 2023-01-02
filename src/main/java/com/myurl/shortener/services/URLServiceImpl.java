package com.myurl.shortener.services;

import com.myurl.shortener.data.model.URLLink;
import com.myurl.shortener.data.repositories.URLRepository;
import com.myurl.shortener.dtos.requests.GetShortURLRequest;
import com.myurl.shortener.dtos.responses.GetLongURLResponse;
import com.myurl.shortener.dtos.responses.GetShortURLResponse;
import com.myurl.shortener.exceptions.InvalidURLException;
import com.myurl.shortener.utils.IDConverter;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.AllArgsConstructor;
import org.hibernate.validator.constraints.URL;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class URLServiceImpl implements URLService {

    private final URLRepository urlRepository;

    @Override
    public GetShortURLResponse getShortURL(@URL GetShortURLRequest getURLRequest) throws InvalidURLException {
        isValidURL(getURLRequest.getLongURL());
        URLLink newURL = new URLLink();
        newURL.setLink(getURLRequest.getLongURL());
        newURL.setId(generateId());
        urlRepository.save(newURL);

        Dotenv dotenv = Dotenv.load();

        GetShortURLResponse response = new GetShortURLResponse();
//        response.setShortURL(System.getenv("url") + "/" + newURL.getId());
        response.setShortURL(dotenv.get("URL") + "/" + newURL.getId());
        return response;
    }

    private String generateId() {
        return IDConverter.convertRequestID(urlRepository.count());
    }

    private void isValidURL(String url) throws InvalidURLException {
        if(!url.matches("^https?:\\/\\/(?:www.)?[-a-zA-Z\\d@:%._\\+~#=]{1,256}" +
                "\\.[a-zA-Z\\d9()]{1,6}\\b(?:[-a-zA-Z\\d@:%._\\+.~#?&\\/=]*)$")) {
            throw new InvalidURLException("The link supplied is invalid. Please try again.");
        }
    }

    @Override
    public GetLongURLResponse getLongURL(String shortURL) {
        String id = getRequestID(shortURL);

        GetLongURLResponse response = new GetLongURLResponse();
        response.setLongURL(urlRepository.findURLLinkById(id).getLink());

        return response;
    }

    private String getRequestID(String shortURL) {
        String[] compArray = shortURL.split("/");
        return compArray[compArray.length - 1];
    }

    @Override
    public long numOfURLs() {
        return urlRepository.count();
    }
}
