package com.lewandowski.feeds.controller;

import com.lewandowski.feeds.service.FeedService;
import com.lewandowski.tweets.dto.TweetDTO;
import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.tweets.util.TweetMapper;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/feed")
public class FeedsController {

    private final Logger LOG = LoggerFactory.getLogger(FeedsController.class);

    @Autowired
    private FeedService feedService;

    @Autowired
    private UserService userService;

    @Autowired
    private TweetMapper tweetMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TweetDTO> getFeed(@PathVariable(value = "userId", required = true) Long userId) {
        LOG.info("Received a request for getFeed for user " + userId);
        User user = userService.findById(userId);
        List<Tweet> tweets = feedService.getFeed(user);
        LOG.debug("returning tweets: " + tweets);
        return tweetMapper.mapEntityToDto(tweets);
    }
}
