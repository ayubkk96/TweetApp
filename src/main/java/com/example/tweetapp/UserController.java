package com.example.tweetapp;

import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("http://localhost:3001")
public class UserController {


    private static final Logger logger = Logger.getLogger(UserController.class.getName());

    @Autowired
    private UserHelper userHelper;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private Gson gson;

    @RequestMapping(path = "/api/v1.0/tweets/register", method = RequestMethod.POST)
    public void register(@RequestBody String user) {
        try {
            System.out.println(user);

            User user1 = gson.fromJson(user, User.class);
            System.out.println(user1);
            userHelper.add(user1);

            userRepo.save(user1);
        }
        catch (Exception e) {
            logger.error("Error thrown with exception: " + e);
        }

    }

    @RequestMapping(path = "/api/v1.0/tweets/login", method = RequestMethod.GET)
    public String login() {
        try {
            User user = new User();

            user.setToken("test123");
            return gson.toJson(user.getToken());
        }
        catch (Exception e) {
            logger.error("Error thrown with exception: " + e);
        }
        return null;
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
