package com.lewandowski.twits.repository;

import com.lewandowski.twits.entity.Twit;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static com.lewandowski.twits.TwitTestConstants.*;

import javax.validation.ConstraintViolationException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TwitRepositoryTest {


    @Autowired
    private TwitRepository twitRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_add_twit_given_valid_fields() {

        Twit twit = new Twit();
        twit.setMessage(MESSAGE);

        twitRepository.save(twit);

        Assert.assertNotNull(twit.getId());
        Assert.assertTrue(MESSAGE.equals(twit.getMessage()));
    }

    @Test
    public void should_add_twit_given_valid_user() {

        User user = new User(USERNAME);
        userRepository.save(user);

        Twit twit = new Twit();
        twit.setMessage(MESSAGE);
        twit.setAuthor(user);

        twitRepository.save(twit);

        Assert.assertNotNull(twit.getId());
        Assert.assertTrue(twit.getAuthor().equals(user));

    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void should_add_twit_given_transient_user() {

        User user = new User(USERNAME);

        Twit twit = new Twit();
        twit.setMessage(MESSAGE);
        twit.setAuthor(user);

        twitRepository.save(twit);

        Assert.assertNotNull(twit.getId());
        Assert.assertTrue(twit.getAuthor().equals(user));

    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldnt_throw_exception_given_empty_message() {
        Twit twit = new Twit();

        twitRepository.save(twit);
    }

    @Test(expected = ConstraintViolationException.class)
    public void shouldnt_throw_exception_given_bad_message() {
        Twit twit = new Twit();
        twit.setMessage(MESSAGE_150);

        twitRepository.save(twit);
    }
}
