package com.lewandowski.twit.controller;


import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.user.dto.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/twits")
public class TwitController {

    @RequestMapping("/{id}")
    public TwitDTO getTwit(@PathVariable("id") Long id) {
        return new TwitDTO(1L, "TestTwit", new UserDTO());
    }

}
