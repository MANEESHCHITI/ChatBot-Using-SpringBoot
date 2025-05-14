package com.UpwardIq.ChatBotProject.exception;

public class BlankMessageException extends RuntimeException {

    public BlankMessageException(String message) {
        super(message);
    }
}
