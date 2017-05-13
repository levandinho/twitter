package com.lewandowski.twit.controller;


import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.twit.entity.Twit;
import com.lewandowski.twit.service.TwitService;
import com.lewandowski.twit.util.TwitModuleConsts;
import com.lewandowski.user.entity.User;
import com.lewandowski.user.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/twits")
public class TwitController {

    @Autowired
    private TwitService twitService;

    @Autowired
    private UserService userService;

    @Autowired
    private MapperFacade mapperFacade;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TwitDTO getTwit(@PathVariable("id") Long id) {
        Twit twit =  twitService.getTwit(id);
        return mapperFacade.map(twit, TwitDTO.class);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<TwitDTO> getTwits() {
        List<TwitDTO> results = mapperFacade.mapAsList(twitService.getTwits(), TwitDTO.class);
        return results;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public long saveTwit(@RequestBody @Valid TwitDTO twitDTO) {
        User user = userService.findById(twitDTO.getAuthorId());
        //If user doesn't exist, simply create one
        if (user == null) {
            user = userService.addUser(new User(TwitModuleConsts.ANONYMOUS + new Date().getTime()));
        }
        Twit twit = mapperFacade.map(twitDTO, Twit.class);
        twit.setAuthor(user);

        return twitService.save(twit);

    }
}
