package com.UpwardIq.ChatBotProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.UpwardIq.ChatBotProject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
