package com.lewandowski.twits.service;

import com.lewandowski.twits.entity.Twit;
import com.lewandowski.users.entity.User;

import java.util.List;

public interface TwitService {

    public Twit save(Twit twit);

    public List<Twit> getTwitsForUser(Long userId);

    public Twit getTwit(Long id);

    public void delete(Long id);
}
