package com.UpwardIq.ChatBotProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.UpwardIq.ChatBotProject.model.User;
import com.UpwardIq.ChatBotProject.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userRepository.save(user);
    }
    

    @PostMapping("/login")
    public boolean login(@RequestParam String userId, @RequestParam String password) {
        User user = userRepository.findByUserId(userId);
        return user != null && user.getPassword().equals(password);
    }
    
    @GetMapping("/registeredData")
    public List<User> registered(){
    	return userRepository.findAll();
    }

}
