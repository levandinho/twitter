package com.lewandowski.twit.controller;


import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.twit.service.TwitService;
import com.lewandowski.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/twits")
public class TwitController {

    @Autowired
    private TwitService twitService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TwitDTO getTwit(@PathVariable("id") Long id) {
        return new TwitDTO(1L, "TestTwit", new UserDTO());
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TwitDTO> getTwits() {
        return twitService.getTwits();
    }

}
