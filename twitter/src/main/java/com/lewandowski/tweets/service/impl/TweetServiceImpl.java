package com.lewandowski.tweets.service.impl;

import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.tweets.repository.TweetRepository;
import com.lewandowski.tweets.service.TweetService;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.repository.UserRepository;
import com.lewandowski.users.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserService userService;

    @Override
    public Tweet save(Tweet tweet) {
        tweetRepository.save(tweet);
        return tweet;
    }

    @Override
    public List<Tweet> getTweetsForUser(Long userId) {
        User user = userService.getUser(userId);
        Hibernate.initialize(user.getTweets());
        return user.getTweets();
    }

    @Override
    public void delete(Long id) {
        tweetRepository.delete(id);
    }

    @Override
    public Tweet getTweet(Long id) {
        return tweetRepository.getOne(id);
    }
}
