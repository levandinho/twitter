package com.lewandowski.tweets.service;

import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.tweets.repository.TweetRepository;
import com.lewandowski.tweets.service.impl.TweetServiceImpl;
import com.lewandowski.users.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.lewandowski.tweets.TweetTestConstants.MESSAGE;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TweetServiceTest {

    @InjectMocks
    private TweetService tweetService = new TweetServiceImpl();

    @Mock
    private TweetRepository tweetRepository;

    @Test
    public void should_invoke_repository_when_saving() {
        Tweet tweet = new Tweet();
        tweet.setMessage(MESSAGE);

        tweet = tweetService.save(tweet);

        verify(tweetRepository, times(1)).save(any(Tweet.class));
    }
}
