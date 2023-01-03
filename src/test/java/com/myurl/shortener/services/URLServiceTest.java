package com.myurl.shortener.services;

import com.myurl.shortener.dtos.requests.GetLongURLRequest;
import com.myurl.shortener.dtos.requests.GetShortURLRequest;
import com.myurl.shortener.dtos.responses.GetLongURLResponse;
import com.myurl.shortener.dtos.responses.GetShortURLResponse;
import com.myurl.shortener.exceptions.InvalidURLException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class URLServiceTest {
    @Autowired
    URLService urlService;

    @Test
    void testThatLongURLCanBeStoredAndConvertedToShortURL() throws InvalidURLException {
        GetShortURLRequest request = new GetShortURLRequest();
//        request.setLongURL("https://scholar.google.com/scholar?hl=en&as_sdt=0%2C5&q=FinTech+%28Financial+Technology%29%3A+What+is+It+and+How+to+Use+Technologies+to+Create+Business+Value+in+Fintech+Way%3F&btnG=");
        request.setLongURL("https://scholar");

        GetShortURLResponse response = urlService.getShortURL(request);
        assertEquals(1, urlService.numOfURLs());
        assertEquals("https://www.myurl.com/a", response.getShortURL());
    }

    @Test
    void testThatShortURLCanRetrieveLongURL() throws InvalidURLException {
        GetShortURLRequest request = new GetShortURLRequest();
        request.setLongURL("https://www.statista.com/outlook/dmo/fintech/worldwide");
        GetShortURLResponse response = urlService.getShortURL(request);

        GetLongURLRequest request1 = new GetLongURLRequest();
        request1.setShortURL(response.getShortURL());
        System.out.println(request1.getShortURL());
        GetLongURLResponse response1 = urlService.getLongURL(request1.getShortURL());
        assertEquals("https://www.statista.com/outlook/dmo/fintech/worldwide", response1.getLongURL());
    }

//    @Test
//    void testThatExceptionIsThrownIfUrlIsInvalid() {
//        GetShortURLRequest request = new GetShortURLRequest();
//        request.setLongURL("https://www.statista");
//        assertThrows(InvalidURLException.class, ()-> urlService.getShortURL(request));
//    }

}