package com.UpwardIq.ChatBotProject.interfaces;

import com.UpwardIq.ChatBotProject.model.User;

import java.util.List;

public interface UserServiceInterface {

    public boolean userIdCheck(String userCheck);

    public User registerUser(User user);

    public boolean loginUser(String userId, String password);

    public List<User> getRegisteredUsersExceptLoggedIn(String loggedInUserId);

}

