package com.myurl.shortener.exceptions;

public class InvalidURLExecption extends URLShortenerException {
    public InvalidURLExecption() {
        super();
    }

    public InvalidURLExecption(String message) {
        super(message);
    }

    public InvalidURLExecption(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidURLExecption(Throwable cause) {
        super(cause);
    }
}
