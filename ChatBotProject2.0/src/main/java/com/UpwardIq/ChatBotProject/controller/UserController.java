package com.UpwardIq.ChatBotProject.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.UpwardIq.ChatBotProject.exception.InvalidCredentialsException;
import com.UpwardIq.ChatBotProject.exception.UserNotFoundException;
import com.UpwardIq.ChatBotProject.model.User;
import com.UpwardIq.ChatBotProject.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/useridcheck")
    public boolean userIdCheck(@RequestParam String usercheck){
         return userService.userIdCheck(usercheck);
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user); // No try-catch needed
    }

    @PostMapping("/login")
    public boolean login(@RequestParam String userId, @RequestParam String password) {
        return userService.loginUser(userId, password); // Exception will be handled globally
    }

    @GetMapping("/registeredData")
    public List<User> getRegisteredUsersExceptLoggedIn(@RequestParam String loggedInUserId) {

            return userService.getRegisteredUsersExceptLoggedIn(loggedInUserId);

    }
}
