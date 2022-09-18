package com.myurl.shortener.exceptions;

public class InvalidURLException extends URLShortenerException {
    public InvalidURLException() {
        super();
    }

    public InvalidURLException(String message) {
        super(message);
    }

    public InvalidURLException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidURLException(Throwable cause) {
        super(cause);
    }
}
