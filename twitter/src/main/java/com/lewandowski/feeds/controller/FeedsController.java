package com.lewandowski.feeds.controller;

import com.lewandowski.feeds.service.FeedService;
import com.lewandowski.twits.dto.TwitDTO;
import com.lewandowski.twits.entity.Twit;
import com.lewandowski.twits.util.TwitMapper;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/feed")
public class FeedsController {

    @Autowired
    private FeedService feedService;

    @Autowired
    private UserService userService;

    @Autowired
    private TwitMapper twitMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TwitDTO> getFeed(@PathVariable(value = "userId", required = true) Long userId) {
        User user = userService.findById(userId);
        List<Twit> twits = feedService.getFeed(user);
        return twitMapper.mapEntityToDto(twits);
    }
}
