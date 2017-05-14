package com.lewandowski.feeds.service;

import com.lewandowski.twits.entity.Twit;
import com.lewandowski.users.entity.User;

import java.util.List;

public interface FeedService {

    /**
     * Retrieves a list of twits which represents a user's timeline (collection of twits of the followees)
     *
     * @param user The user for whom the list is returned
     */
    public List<Twit> getFeed(User user);
}
