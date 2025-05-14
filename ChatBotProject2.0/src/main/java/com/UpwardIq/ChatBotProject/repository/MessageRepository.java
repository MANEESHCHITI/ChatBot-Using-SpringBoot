package com.UpwardIq.ChatBotProject.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.UpwardIq.ChatBotProject.model.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    @Query("SELECT m FROM Message m WHERE " +
           "(m.senderId = :sUserId AND m.receiverId = :rUserId) " +
           "OR (m.senderId = :rUserId AND m.receiverId = :sUserId)")
    List<Message> findChatBetweenUsers(@Param("sUserId") String senderId, @Param("rUserId") String receiverId);
}
