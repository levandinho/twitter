package com.lewandowski.user.service;

import com.lewandowski.user.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long authorId);

    User addUser(User user);

    List<User> getUsers();
}
