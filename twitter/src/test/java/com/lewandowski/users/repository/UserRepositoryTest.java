package com.lewandowski.users.repository;

import com.lewandowski.tweets.repository.TweetRepository;
import com.lewandowski.users.entity.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.validation.ConstraintViolationException;

import static com.lewandowski.users.repository.UserTestConstants.USERNAME;
import static com.lewandowski.users.repository.UserTestConstants.WRONG_USERNAME;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TweetRepository tweetRepository;

    @Test
    public void should_add_user_given_valid_fields() {
        User user = new User(UserTestConstants.USERNAME);

        userRepository.save(user);

        Assert.assertNotNull(user.getId());
        Assert.assertTrue(USERNAME.equals(user.getUsername()));
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldnt_add_user_invalid_username() {
        User user = new User(WRONG_USERNAME);

        userRepository.save(user);

        Assert.assertNotNull(user.getId());
    }
}