package com.lewandowski.user.controller;

import com.lewandowski.twit.util.TwitMapper;
import com.lewandowski.user.util.UserMapper;
import com.lewandowski.twit.entity.Twit;
import com.lewandowski.twit.service.TwitService;
import com.lewandowski.user.dto.RegisterDTO;
import com.lewandowski.user.dto.UserDTO;
import com.lewandowski.user.entity.User;
import com.lewandowski.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TwitService twitService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    TwitMapper twitMapper;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserDTO getUser(@PathVariable("id") long userId) {
        User user = userService.getUser(userId);
        return userMapper.mapEntityToDto(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("id") long userId) {
        userService.delete(userId);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserDTO> findUsers(@RequestParam("query") String query) {
        List<User> users = userService.find(query);
        return userMapper.mapEntityToDto(users);
    }

    @RequestMapping(value = "new/twits", method = RequestMethod.POST)
    public UserDTO registerAndTwit(@RequestBody @Valid RegisterDTO registerDTO) {
        User user = new User(registerDTO.getUsername());
        user = userService.addUser(user);
        Twit twit = twitMapper.mapDtoToEntity(registerDTO.getFirstTwit());
        twit.setAuthor(user);
        twitService.save(twit);
        return userMapper.mapEntityToDto(user);
    }

}
