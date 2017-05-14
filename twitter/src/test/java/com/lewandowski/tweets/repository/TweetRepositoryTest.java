package com.lewandowski.tweets.repository;

import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static com.lewandowski.tweets.TweetTestConstants.*;

import javax.validation.ConstraintViolationException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TweetRepositoryTest {

    @Autowired
    private TweetRepository tweetRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_add_tweet_given_valid_fields() {
        Tweet tweet = new Tweet();
        tweet.setMessage(MESSAGE);

        tweetRepository.save(tweet);

        Assert.assertNotNull(tweet.getId());
        Assert.assertTrue(MESSAGE.equals(tweet.getMessage()));
    }

    @Test
    public void should_add_tweet_given_valid_user() {
        User user = new User(USERNAME);
        userRepository.save(user);

        Tweet tweet = new Tweet();
        tweet.setMessage(MESSAGE);
        tweet.setAuthor(user);

        tweetRepository.save(tweet);

        Assert.assertNotNull(tweet.getId());
        Assert.assertTrue(tweet.getAuthor().equals(user));

    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void shouldnt_add_tweet_given_transient_user() {
        User user = new User(USERNAME);
        Tweet tweet = new Tweet();
        tweet.setMessage(MESSAGE);
        tweet.setAuthor(user);

        tweetRepository.save(tweet);

        Assert.assertNotNull(tweet.getId());
        Assert.assertTrue(tweet.getAuthor().equals(user));
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldnt_throw_exception_given_empty_message() {
        Tweet tweet = new Tweet();

        tweetRepository.save(tweet);
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldnt_throw_exception_given_bad_message() {
        Tweet tweet = new Tweet();
        tweet.setMessage(MESSAGE_150);

        tweetRepository.save(tweet);
    }
}
