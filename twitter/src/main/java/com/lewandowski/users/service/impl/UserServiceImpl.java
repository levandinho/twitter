package com.lewandowski.users.service.impl;

import com.lewandowski.users.entity.User;
import com.lewandowski.users.repository.UserRepository;
import com.lewandowski.users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long authorId) {
        return userRepository.findOne(authorId);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long userId) {
        return userRepository.findOne(userId);
    }

    @Override
    public void delete(long userId) {
        userRepository.delete(userId);
    }

    @Override
    public List<User> find(String query) {
        if (query != null) {
            return userRepository.findByUsernameLike("%" + query + "%");
        } else {
            return userRepository.findAll();
        }

    }

    @Override
    public List<User> getFollowers(Long userId) {
        User user = userRepository.findOne(userId);
        return user.getFollowees();
    }

    @Override
    public User addFollowee(Long userId, Long followeeId) {
        User user = userRepository.findOne(userId);
        User followee = userRepository.findOne(followeeId);
        user.getFollowees().add(followee);
        userRepository.save(user);
        return user;
    }

    @Override
    public User removeFollowee(Long userId, Long followeeId) {
        User user = userRepository.findOne(userId);
        User followee = userRepository.findOne(followeeId);
        user.getFollowees().remove(followee);
        return user;
    }
}
