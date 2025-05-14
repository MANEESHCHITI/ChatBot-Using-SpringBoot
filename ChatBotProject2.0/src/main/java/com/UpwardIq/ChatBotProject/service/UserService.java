package com.UpwardIq.ChatBotProject.service;

import java.util.List;

import com.UpwardIq.ChatBotProject.exception.ReceiverListExceptLoggedException;
import com.UpwardIq.ChatBotProject.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.UpwardIq.ChatBotProject.exception.InvalidCredentialsException;
import com.UpwardIq.ChatBotProject.exception.UserNotFoundException;
import com.UpwardIq.ChatBotProject.model.User;
import com.UpwardIq.ChatBotProject.repository.UserRepository;
import com.UpwardIq.ChatBotProject.exception.UserIdExistsException;

@Service
public class UserService implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean userIdCheck(String userCheck){
        return userRepository.existsByUserId(userCheck);

    }
    @Override
    public User registerUser(User user) {
        if (userRepository.existsByUserId(user.getUserId())) {

            throw new UserIdExistsException("User already exists with ID: " + user.getUserId());
        }
        return userRepository.save(user);
    }

    @Override
    public boolean loginUser(String userId, String password) {

        User user = userRepository.findByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found for ID: " + userId);
        }
        if (!user.getPassword().equals(password)) {
            throw new InvalidCredentialsException("Invalid password for user ID: " + userId);
        }
        return true;

    }

    @Override
    public List<User> getRegisteredUsersExceptLoggedIn(String loggedInUserId) {

        List<User> users=userRepository.findAllByUserIdNot(loggedInUserId);

        if (users.isEmpty()) {
            throw new ReceiverListExceptLoggedException("No registered users found.");
        }
        return users;

    }
}
