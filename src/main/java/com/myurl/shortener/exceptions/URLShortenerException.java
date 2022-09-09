package com.myurl.shortener.exceptions;

public class URLShortenerException extends Exception {
    public URLShortenerException() {
        super();
    }

    public URLShortenerException(String message) {
        super(message);
    }

    public URLShortenerException(String message, Throwable cause) {
        super(message, cause);
    }

    public URLShortenerException(Throwable cause) {
        super(cause);
    }
}
