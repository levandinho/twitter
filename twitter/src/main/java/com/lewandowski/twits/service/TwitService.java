package com.lewandowski.twits.service;

import com.lewandowski.twits.entity.Twit;
import com.lewandowski.users.entity.User;

import java.util.List;

public interface TwitService {

    /**
     * Saves a twit
     *
     * @param twit a Twit entity to be saved
     */
    public Twit save(Twit twit);

    /**
     * Retrieves a list of the user's twits in a reverse chronological order
     *
     * @param userId an unique identifier of a user
     */
    public List<Twit> getTwitsForUser(Long userId);

    /**
     * Retrieves a Twit
     *
     * @param id an unique identifier of a twit to retrieve
     */
    public Twit getTwit(Long id);

    /**
     * Deletes a twit
     *
     * @param id an unique identifier of a twit for deletion
     */
    public void delete(Long id);
}
