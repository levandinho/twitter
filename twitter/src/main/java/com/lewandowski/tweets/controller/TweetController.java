package com.lewandowski.tweets.controller;


import com.lewandowski.tweets.dto.TweetDTO;
import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.tweets.service.TweetService;
import com.lewandowski.tweets.util.TweetMapper;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users/{userId}/tweets")
public class TweetController {

    private final Logger LOG = LoggerFactory.getLogger(TweetController.class);

    @Autowired
    private TweetService tweetService;

    @Autowired
    private UserService userService;

    @Autowired
    private TweetMapper tweetMapper;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TweetDTO getTweet(@PathVariable(value = "id", required = true) Long id) {
        LOG.info("Received a request for getTweet with id " + id);
        Tweet tweet =  tweetService.getTweet(id);
        return tweetMapper.mapEntityToDto(tweet);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TweetDTO> getTweets(@PathVariable(value = "userId", required = true) Long userId) {
        LOG.info("Received a request for getTweets with user id " + userId);
        List<TweetDTO> results = tweetMapper.mapEntityToDto(tweetService.getTweetsForUser(userId));
        return results;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TweetDTO saveTweet(@PathVariable("userId") Long userId, @RequestBody @Valid TweetDTO tweetDTO) {
        LOG.info("Received a request for saveTweet: " + tweetDTO);
        User user = userService.getUser(userId);
        Tweet tweet = tweetMapper.mapDtoToEntity(tweetDTO);
        tweet.setAuthor(user);
        return tweetMapper.mapEntityToDto(tweetService.save(tweet));
    }
}
