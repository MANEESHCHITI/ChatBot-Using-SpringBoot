package com.UpwardIq.ChatBotProject.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UpwardIq.ChatBotProject.model.Message;
import com.UpwardIq.ChatBotProject.repository.MessageRepository;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }
    
	@GetMapping("/chat")
    public List<Message> getChat(@RequestParam String sUserId,@RequestParam String rUserId) {
        return messageRepository.findChatBetweenUsers(sUserId, rUserId);
    }
	
	@GetMapping("/allMessages")
	public List<Message> getAll(){
		return messageRepository.findAll();
	}
	    
 
}

