package com.example.tweetapp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {


    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private UserRepo userRepo;

    @RequestMapping(path = "/api/v1.0/tweets/register", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        try {
            // userHelper.add(user);
            userRepo.save(user);
        }
        catch (Exception e) {
            logger.error("Error thrown with exception: " + e);
        }

    }

    @RequestMapping(path = "/api/v1.0/tweets/login", method = RequestMethod.GET)
    public void login(@RequestBody User user) {
        try {
            // userHelper.login(user);
            user.setLoggedIn(true);
            userRepo.save(user);
        }
        catch (Exception e) {
            logger.error("Error thrown with exception: " + e);
        }

    }

    @RequestMapping(path = "/api/v1.0/tweets/users/all", method = RequestMethod.GET)
    public ArrayList<User> getUsers() {
        try {
            // userHelper.getAllUsers();
            return  (ArrayList<User>) userRepo.findAll();
        }
        catch (Exception e) {
            logger.error("Error thrown with exception: " + e);
        }
        return null;

    }

    @RequestMapping(path = "/api/v1.0/tweets/user/search/{username}", method = RequestMethod.GET)
    public User getUser(@PathVariable String username) {
        try {
            return userRepo.getUserByUsername(username);
        }
        catch (Exception e) {
            logger.error("Error thrown with exception: " + e);
        }
        return null;
    }
}
