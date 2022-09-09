package com.myurl.shortener.controllers;

import com.myurl.shortener.dtos.requests.GetLongURLRequest;
import com.myurl.shortener.dtos.requests.GetShortURLRequest;
import com.myurl.shortener.exceptions.InvalidURLExecption;
import com.myurl.shortener.services.URLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {
    @Autowired
    private URLService urlService;

    @PostMapping("/shortenURL")
    public ResponseEntity<?> getShortURL(@RequestBody GetShortURLRequest getURLRequest) {
        try {
            return new ResponseEntity<>(urlService.getShortURL(getURLRequest), HttpStatus.CREATED);
        } catch (InvalidURLExecption ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getLongURL(@RequestBody GetLongURLRequest getURLRequest) {
        try {
            return new ResponseEntity<>(urlService.getLongURL(getURLRequest), HttpStatus.CREATED);
        } catch (InvalidURLExecption ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
