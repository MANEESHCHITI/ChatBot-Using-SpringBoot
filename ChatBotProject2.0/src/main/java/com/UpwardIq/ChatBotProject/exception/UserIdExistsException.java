package com.UpwardIq.ChatBotProject.exception;

public class UserIdExistsException extends RuntimeException {

    public UserIdExistsException(String message) {
        super(message);
    }
}
