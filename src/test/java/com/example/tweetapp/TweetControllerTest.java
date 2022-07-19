package com.example.tweetapp;



import org.junit.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;


public class TweetControllerTest {


    private TweetHelper tweetHelper = new TweetHelper();


    private TweetRepo tweetRepo = new TweetRepo() {
        @Override
        public ArrayList<Tweet> getTweetsByHandleName(String handleName) {
            return null;
        }

        @Override
        public Tweet getTweetsById(String id) {
            return null;
        }

        @Override
        public <S extends Tweet> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<Tweet> findAll() {
            return null;
        }

        @Override
        public List<Tweet> findAll(Sort sort) {
            return null;
        }

        @Override
        public <S extends Tweet> S insert(S entity) {
            return null;
        }

        @Override
        public <S extends Tweet> List<S> insert(Iterable<S> entities) {
            return null;
        }

        @Override
        public <S extends Tweet> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends Tweet> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<Tweet> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Tweet> S save(S entity) {
            return null;
        }

        @Override
        public Optional<Tweet> findById(String s) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(String s) {
            return false;
        }

        @Override
        public Iterable<Tweet> findAllById(Iterable<String> strings) {
            return null;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(String s) {

        }

        @Override
        public void delete(Tweet entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends String> strings) {

        }

        @Override
        public void deleteAll(Iterable<? extends Tweet> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends Tweet> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends Tweet> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends Tweet> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends Tweet> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends Tweet, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void getData() {
        String tweetCopy;
        tweetCopy = String.valueOf(tweetRepo.getTweetsById(String.valueOf(4)));
        assertNotEquals("test", tweetCopy);

    }

    @Test
    public void saveData(){
        Tweet tweet = new Tweet();
        tweetHelper.addTweet(tweet);
        boolean saved;
        try {
            tweetRepo.save(tweet);
            saved = true;
        }
        catch (Exception e) {
            saved = false;
        }
        assertTrue(saved);
    }



}
