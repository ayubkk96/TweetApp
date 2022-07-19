package com.example.tweetapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserHelper {

    private static ArrayList<User> users = new ArrayList<>();

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public User getUser(String username) {
        for (User user: users) {
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public void add(User user) {
        users.add(user);
    }

    public void login(User user) {
       user.setLoggedIn(true);
    }
}
