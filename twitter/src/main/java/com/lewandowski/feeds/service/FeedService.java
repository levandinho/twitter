package com.lewandowski.feeds.service;

import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.users.entity.User;

import java.util.List;

public interface FeedService {

    /**
     * Retrieves a list of tweets which represents a user's timeline (collection of tweets of the followees)
     *
     * @param user The user for whom the list is returned
     */
    public List<Tweet> getFeed(User user);
}
