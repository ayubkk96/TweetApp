package com.example.tweetapp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;

public interface UserRepo extends MongoRepository <User, String>{
    @Query("{username: ?0}")
    User getUserByUsername(String username);
}
