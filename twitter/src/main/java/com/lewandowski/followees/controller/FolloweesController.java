package com.lewandowski.followees.controller;

import com.lewandowski.followees.dto.AddFolloweeRequestDTO;
import com.lewandowski.users.dto.UserDTO;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.service.UserService;
import com.lewandowski.users.util.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users/{userId}/followees")
public class FolloweesController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserDTO> getFollowees(@PathVariable(value = "userId", required = true) Long userId) {
        Set<User> folowees = userService.getFollowers(userId);
        return userMapper.mapEntityToDto(folowees);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public UserDTO addFollowee(@PathVariable(value = "userId", required = true) Long userId, @RequestBody @Valid AddFolloweeRequestDTO requestDTO) {
        return userMapper.mapEntityToDto(userService.addFollowee(userId, requestDTO.getFolloweeId()));
    }

    @RequestMapping(value = "/{followeeId}", method = RequestMethod.DELETE)
    public UserDTO deleteFollowee(@PathVariable(value = "userId", required = true) Long userId, @PathVariable(value = "followeeId", required = true) Long followeeId) {
        return userMapper.mapEntityToDto(userService.removeFollowee(userId, followeeId));
    }
}
