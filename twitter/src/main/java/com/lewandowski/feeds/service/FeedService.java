package com.lewandowski.feeds.service;

import com.lewandowski.twits.entity.Twit;
import com.lewandowski.users.entity.User;

import java.util.List;

public interface FeedService {

    public List<Twit> getFeed(User user);
}
