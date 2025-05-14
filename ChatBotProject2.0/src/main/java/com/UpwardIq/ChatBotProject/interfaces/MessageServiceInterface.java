package com.UpwardIq.ChatBotProject.interfaces;

import com.UpwardIq.ChatBotProject.model.Message;

import java.util.List;

public interface MessageServiceInterface {

    public Message sendMessage(Message message);

    public List<Message> getChat(String senderId, String receiverId);



}
