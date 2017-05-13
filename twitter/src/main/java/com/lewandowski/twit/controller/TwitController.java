package com.lewandowski.twit.controller;


import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.twit.entity.Twit;
import com.lewandowski.twit.service.TwitService;
import com.lewandowski.twit.util.TwitMapper;
import com.lewandowski.user.entity.User;
import com.lewandowski.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users/{userId}/twits")
public class TwitController {

    @Autowired
    private TwitService twitService;

    @Autowired
    private UserService userService;

    @Autowired
    private TwitMapper twitMapper;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TwitDTO getTwit(@PathVariable(value = "id", required = true) Long id) {
        Twit twit =  twitService.getTwit(id);
        return twitMapper.mapEntityToDto(twit);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TwitDTO> getTwits(@PathVariable(value = "userId", required = true) Long userId) {
        List<TwitDTO> results = twitMapper.mapEntityToDto(twitService.getTwitsForUser(userId));
        return results;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public TwitDTO saveTwit(@PathVariable("userId") Long userId, @RequestBody @Valid TwitDTO twitDTO) {
        User user = userService.findById(userId);
        Twit twit = twitMapper.mapDtoToEntity(twitDTO);
        twit.setAuthor(user);
        return twitMapper.mapEntityToDto(twitService.save(twit));
    }
}
