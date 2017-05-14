package com.lewandowski.users.controller;

import com.lewandowski.twits.util.TwitMapper;
import com.lewandowski.users.util.UserMapper;
import com.lewandowski.twits.entity.Twit;
import com.lewandowski.twits.service.TwitService;
import com.lewandowski.users.dto.RegisterDTO;
import com.lewandowski.users.dto.UserDTO;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.service.UserService;
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
    public List<UserDTO> findUsers(@RequestParam(value = "query", required = false) String query) {
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
