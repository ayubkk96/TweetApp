package com.example.tweetapp;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;

public interface TweetRepo extends MongoRepository<Tweet, String> {

    @Query("{handleName: ?0}")
    ArrayList<Tweet> getTweetsByHandleName(String handleName);

    Tweet getTweetsById(String id);
}
