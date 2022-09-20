package com.myurl.shortener.controllers;

import com.myurl.shortener.dtos.requests.GetShortURLRequest;
import com.myurl.shortener.exceptions.InvalidURLException;
import com.myurl.shortener.services.URLService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
public class URLController {
    private final URLService urlService;

    @PostMapping("/shortenURL")
    public ResponseEntity<?> getShortURL(@RequestBody GetShortURLRequest getURLRequest) {
        try {
            return new ResponseEntity<>(urlService.getShortURL(getURLRequest), HttpStatus.CREATED);
        } catch (InvalidURLException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{shortURL}")
    public ResponseEntity<Void> getLongURL(@PathVariable String shortURL) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(urlService.getLongURL(shortURL).getLongURL()));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }
}
