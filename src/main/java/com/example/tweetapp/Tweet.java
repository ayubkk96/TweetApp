package com.example.tweetapp;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class Tweet {

    @Id
    private String id;
    private String handleName;
    private String message;
    private String tweetTime;
    private String avatarLink;
    private int likesCount;

    private ArrayList<String> likedBy = new ArrayList<>();

    private ArrayList<Tweet> repliedTo = new ArrayList<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHandleName() {
        return handleName;
    }

    public void setHandleName(String handleName) {
        this.handleName = handleName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTweetTime() {
        return tweetTime;
    }

    public void setTweetTime(String tweetTime) {
        this.tweetTime = tweetTime;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }

    public ArrayList<String> getLikedBy() {
        return likedBy;
    }

    public void setLikedBy(ArrayList<String> likedBy) {
        this.likedBy = likedBy;
    }

    public ArrayList<Tweet> getRepliedTo() {
        return repliedTo;
    }

    public void setRepliedTo(ArrayList<Tweet> repliedTo) {
        this.repliedTo = repliedTo;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "id='" + id + '\'' +
                ", handleName='" + handleName + '\'' +
                ", message='" + message + '\'' +
                ", tweetTime='" + tweetTime + '\'' +
                ", avatarLink='" + avatarLink + '\'' +
                ", likesCount=" + likesCount +
                ", likedBy=" + likedBy +
                ", repliedTo=" + repliedTo +
                '}';
    }
}
