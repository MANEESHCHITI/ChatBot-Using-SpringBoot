package com.UpwardIq.ChatBotProject.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.UpwardIq.ChatBotProject.model.Message;
import com.UpwardIq.ChatBotProject.service.MessageService;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {

            return messageService.sendMessage(message);

    }

    @GetMapping("/chat")
    public List<Message> getChat(@RequestParam String sUserId, @RequestParam String rUserId) {

            List<Message> chat = messageService.getChat(sUserId, rUserId);

            return chat;

    }


}
