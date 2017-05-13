package com.lewandowski.users.service;

import com.lewandowski.users.entity.User;

import java.util.List;

public interface UserService {
    User findById(Long authorId);

    User addUser(User user);

    List<User> getUsers();

    User getUser(long userId);

    void delete(long userId);

    List<User> find(String query);

    List<User> getFollowers(Long userId);

    User addFollowee(Long userId, Long followeeId);

    User removeFollowee(Long userId, Long followeeId);
}
