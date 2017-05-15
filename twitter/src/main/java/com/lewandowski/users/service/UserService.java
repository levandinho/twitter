package com.lewandowski.users.service;

import com.lewandowski.users.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    /**
     * Adds a new user
     *
     * @param user The User object to be added
     */
    User addUser(User user);

    /**
     * Returns a list of all users in the system
     */
    List<User> getUsers();

    /**
     * Returns a user with specified identifier
     *
     * @param userId The id of an user we want to get
     * @return User entity
     * @throws javax.persistence.EntityNotFoundException if the user is not present in the system
     */
    User getUser(long userId);

    /**
     * Deletes a user
     *
     * @param userId an unique identifier of a user for deletion
     */
    void delete(long userId);

    /**
     * Retrieves a list of users matching specified criteria (username like query)
     *
     * @param query a username substring which can be used for filtering
     */
    List<User> find(String query);

    /**
     * Retrieves a list of followees of the specified userr
     *
     * @param userId an unique identifier of a user who followees we want to get
     */
    Set<User> getFollowers(Long userId);

    /**
     * Adds a followee
     *
     * @param userId an unique identifier of an user
     * @param followeeId an unique identifier of a followee
     * @return The user specified by the identifier
     */
    User addFollowee(Long userId, Long followeeId);

    /**
     * Removes a followee
     *
     * @param userId an unique identifier of an user
     * @param followeeId an unique identifier of a followee
     * @return The user specified by the identifier
     */
    User removeFollowee(Long userId, Long followeeId);
}
