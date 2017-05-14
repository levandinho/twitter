package com.lewandowski.feeds.service.impl;

import com.lewandowski.feeds.service.FeedService;
import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.tweets.repository.TweetRepository;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class FeedServiceImpl implements FeedService {

    @Autowired
    private TweetRepository tweetRepository;

    @Override
    public List<Tweet> getFeed(User user) {
        return tweetRepository.findByAuthorInOrderByDateAddedDesc(user.getFollowees());
    }
}
