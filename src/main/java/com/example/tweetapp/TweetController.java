package com.example.tweetapp;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class TweetController {

    private static final Logger logger = Logger.getLogger(TweetController.class.getName());

    @Autowired
    private TweetHelper tweetHelper;

    @Autowired
    private TweetRepo tweetRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;



    @RequestMapping(path = "/api/v1.0/tweets/all", method = RequestMethod.GET)
    public ArrayList<Tweet> getTweets() {
        //tweetHelper.addDummyTweet();
        //tweetHelper.getAllTweets();
        kafkaTemplate.send("tweettopic", String.valueOf(tweetRepo.findAll()));
        logger.log(Level.INFO, "Level has been logged with info level");
        return (ArrayList<Tweet>) tweetRepo.findAll();
    }

    @RequestMapping(path = "/api/v1.0/tweets/{username}", method = RequestMethod.GET)
    public ArrayList<Tweet>  getUserTweets(@PathVariable String username) {
        //tweetRepo.findBy();
        try {
            kafkaTemplate.send("tweettopic", String.valueOf(tweetRepo.getTweetsByHandleName(username)));
        }
        catch (Exception e) {
            logger.error("There seems to be an error: " + e);
        }
        return tweetRepo.getTweetsByHandleName(username);
    }

    @RequestMapping(path = "/api/v1.0/tweets/{username}/add", method = RequestMethod.POST)
    public void addTweet(@PathVariable String username, @RequestBody Tweet tweet) {
        try {
            //tweetHelper.addTweet(tweet)
            kafkaTemplate.send("tweettopic", String.valueOf(tweet));
            tweetRepo.save(tweet);
            System.out.println("added tweet with id: " + tweet.getId());
        }
        catch (Exception e) {
            logger.error("There seems to be an error: " + e);
        }

    }

    @RequestMapping(value = "/api/v1.0/tweets/{username}/update/{id}", method = RequestMethod.PUT)
    public void updateTweet(@RequestBody Tweet tweet, @PathVariable String username,
                            @PathVariable String id){
        try {
            //tweetHelper.updateTweet(tweet, id, username);
            tweetRepo.save(tweet);
        }
        catch (Exception e) {
            logger.error("There seems to be an error: " + e);
        }

    }

    @RequestMapping(value = "/api/v1.0/tweets/{username}/delete/{id}", method = RequestMethod.DELETE)
    public void deleteTweet(@PathVariable String username, @PathVariable String id){
        //tweetHelper.deleteTweet(id, username);
        tweetRepo.deleteById(id);
    }

    @RequestMapping(value = "/api/v1.0/tweets/{username}/like/{id}", method = RequestMethod.PUT)
    public void likeTweet(@PathVariable String username, @PathVariable String id) {

        tweetHelper.likeTweet(id, username);
        Tweet tweet = tweetRepo.getTweetsById(id);
        tweet.getLikedBy().add(username);
        tweet.setLikesCount(tweet.getLikesCount() + 1);
        tweetRepo.save(tweet);
    }

    @RequestMapping(value = "/api/v1.0/tweets/{username}/reply/{id}", method = RequestMethod.POST)
    public void replyTweet(@RequestBody Tweet tweet, @PathVariable String username,
                           @PathVariable String id) {
        //tweetHelper.replyTweet(tweet, id, username);
        Tweet repliedToTweet = tweetRepo.getTweetsById(id);

        tweet.getRepliedTo().add(repliedToTweet);
        tweetRepo.save(tweet);
    }



}
