package com.lewandowski.user.controller;

import com.lewandowski.user.dto.UserDTO;
import com.lewandowski.user.entity.User;
import com.lewandowski.user.service.UserService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MapperFacade mapperFacade;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<UserDTO> getUsers() {
        List<User> users = userService.getUsers();
        return mapperFacade.mapAsList(users, UserDTO.class);
    }

}
