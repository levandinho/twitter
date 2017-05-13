package com.lewandowski.twit.service;

import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.twit.entity.Twit;

import java.util.List;

public interface TwitService {

    public long save(Twit twit);

    public List<Twit> getTwits();

    Twit getTwit(Long id);
}
