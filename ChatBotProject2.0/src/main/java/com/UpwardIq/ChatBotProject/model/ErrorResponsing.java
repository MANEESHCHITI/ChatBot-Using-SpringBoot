package com.UpwardIq.ChatBotProject.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorResponsing{
    private LocalDateTime localDateTime;
    private String message;
    private String details;

    public ErrorResponsing(LocalDateTime localDateTime, String message, String details) {
        this.localDateTime = localDateTime;
        this.message = message;
        this.details = details;
    }

    public ErrorResponsing(LocalDateTime localDateTime, String message) {
        this.localDateTime = localDateTime;
        this.message = message;
    }
}
