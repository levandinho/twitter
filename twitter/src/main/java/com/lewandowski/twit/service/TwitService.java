package com.lewandowski.twit.service;

import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.twit.entity.Twit;

import java.util.List;

public interface TwitService {

    public Twit save(Twit twit);

    public List<Twit> getTwitsForUser(Long userId);

    Twit getTwit(Long id);
}
