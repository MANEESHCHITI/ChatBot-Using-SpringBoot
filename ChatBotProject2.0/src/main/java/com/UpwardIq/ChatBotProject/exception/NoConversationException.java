package com.UpwardIq.ChatBotProject.exception;

public class NoConversationException extends RuntimeException {
    public NoConversationException(String message)
    {
        super(message);
    }
}
