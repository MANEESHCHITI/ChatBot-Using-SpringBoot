package com.UpwardIq.ChatBotProject.service;

import java.time.LocalDateTime;
import java.util.List;

import com.UpwardIq.ChatBotProject.exception.BlankMessageException;
import com.UpwardIq.ChatBotProject.exception.NoConversationException;
import com.UpwardIq.ChatBotProject.interfaces.MessageServiceInterface;
import com.UpwardIq.ChatBotProject.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.UpwardIq.ChatBotProject.model.Message;
import com.UpwardIq.ChatBotProject.repository.MessageRepository;

@Service
public class MessageService implements MessageServiceInterface {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message sendMessage(Message message) {

        if(message.getMessage().isBlank()){
                throw new BlankMessageException("Blank Message");
        }
        else{
            message.setTimestamp(LocalDateTime.now());
            return messageRepository.save(message);
        }



    }

    @Override
    public List<Message> getChat(String senderId, String receiverId) {

            List<Message> chat = messageRepository.findChatBetweenUsers(senderId, receiverId);
            if (chat.isEmpty()) {
                throw new NoConversationException("No Conversations.");
            }
            else{
                return chat;
            }


    }

}
