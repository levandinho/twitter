package com.lewandowski.users.controller;

import com.lewandowski.tweets.util.TweetMapper;
import com.lewandowski.users.util.UserMapper;
import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.tweets.service.TweetService;
import com.lewandowski.users.dto.RegisterDTO;
import com.lewandowski.users.dto.UserDTO;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private TweetService tweetService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TweetMapper tweetMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") long userId) {
        LOG.info("Received a request for getUser with user id " + userId);
        User user = userService.getUser(userId);
        return userMapper.mapEntityToDto(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long userId) {
        LOG.info("Received a request for deleteUser with user id " + userId);
        userService.delete(userId);
        LOG.info("user with id " + userId + " Successfully deleted");
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<UserDTO> findUsers(@RequestParam(value = "query", required = false) String query) {
        LOG.info("Received a request for findUsers with username query: " + query);
        List<User> users = userService.find(query);
        LOG.debug("Found the following users: " + users);
        return userMapper.mapEntityToDto(users);
    }

    @RequestMapping(value = "new/tweets", method = RequestMethod.POST)
    public UserDTO registerAndTweet(@RequestBody @Valid RegisterDTO registerDTO) {
        LOG.info("Received a request for registerAndTweet: " + registerDTO);
        User user = new User(registerDTO.getUsername());
        user = userService.addUser(user);
        LOG.debug("Registered a new user: " + user);
        Tweet tweet = tweetMapper.mapDtoToEntity(registerDTO.getFirstTweet());
        tweet.setAuthor(user);
        tweetService.save(tweet);
        return userMapper.mapEntityToDto(user);
    }
}
