package com.lewandowski.feeds.service.impl;

import com.lewandowski.feeds.service.FeedService;
import com.lewandowski.twits.entity.Twit;
import com.lewandowski.twits.repository.TwitRepository;
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
    private TwitRepository twitRepository;

    @Override
    public List<Twit> getFeed(User user) {
        return twitRepository.findByAuthorInOrderByDateAddedDesc(user.getFollowees());
    }
}
