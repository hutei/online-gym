package com.hutei.Service.Exception;

public class PasswordMatchingException extends Throwable {
    public PasswordMatchingException() {
        super();
    }

    public PasswordMatchingException(String message) {
        super(message);
    }

    public PasswordMatchingException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordMatchingException(Throwable cause) {
        super(cause);
    }
}
