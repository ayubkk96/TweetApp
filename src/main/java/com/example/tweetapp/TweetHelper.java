package com.example.tweetapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TweetHelper {
    private static ArrayList<Tweet> tweets = new ArrayList<>();
    public ArrayList<Tweet> getAllTweets() {
        return tweets;
    }

    public ArrayList<Tweet> getUserTweets(String userName) {
        ArrayList<Tweet> userTweets = new ArrayList<>();

        for (Tweet tweet: tweets) {
            if (tweet.getHandleName().equals(userName)){
                userTweets.add(tweet);
            }
        }
        return userTweets;
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public void updateTweet(Tweet tweet, String id, String username) {
        for (Tweet t: tweets) {
            if (t.getId().equals(id)){
                t.setId(tweet.getId());
                t.setAvatarLink(tweet.getAvatarLink());
                t.setTweetTime(tweet.getTweetTime());
                t.setHandleName(tweet.getHandleName());
                t.setMessage(tweet.getMessage());
            }
        }
    }
    //We must use the removeIf Method in order to avoid concurrent modification exception
    public void deleteTweet(String id, String username) {
        tweets.removeIf(t -> t.getId().equals(id));
    }

    public void likeTweet(String id, String username) {
        for (Tweet t: tweets) {
            if (t.getId().equals(id)){
                t.setLikesCount(t.getLikesCount() + 1);
                t.getLikedBy().add(username);
            }
        }
    }

    public void replyTweet(Tweet tweet, String id, String username) {
        for (Tweet t: tweets) {
            if (t.getId().equals(id)){
                t.getRepliedTo().add(tweet);
            }
        }
    }

    public void addDummyTweet() {
        System.out.println("doin it");
        Tweet tweet1 = new Tweet();
        tweet1.setId(String.valueOf(1));
        tweet1.setMessage("yoooo");
        tweet1.setTweetTime(String.valueOf(System.currentTimeMillis()));
        tweet1.setHandleName("jameslikespie");
        tweets.add(tweet1);
    }
}
