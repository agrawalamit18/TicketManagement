package com.content.mgnt.error;

public class ContentException extends Exception{

    public ContentException() {
        super();
    }

    public ContentException(String message) {
        super(message);
    }

    public ContentException(String message, Throwable cause) {
        super(message, cause);
    }
}
