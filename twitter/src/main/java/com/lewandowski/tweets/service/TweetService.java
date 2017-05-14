package com.lewandowski.tweets.service;

import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.users.entity.User;

import java.util.List;

public interface TweetService {

    /**
     * Saves a tweet
     *
     * @param tweet a Tweet entity to be saved
     */
    public Tweet save(Tweet tweet);

    /**
     * Retrieves a list of the user's tweets in a reverse chronological order
     *
     * @param userId an unique identifier of a user
     */
    public List<Tweet> getTweetsForUser(Long userId);

    /**
     * Retrieves a Tweet
     *
     * @param id an unique identifier of a tweet to retrieve
     */
    public Tweet getTweet(Long id);

    /**
     * Deletes a tweet
     *
     * @param id an unique identifier of a tweet for deletion
     */
    public void delete(Long id);
}
