package com.lewandowski.twit.service;

import com.lewandowski.twit.dto.TwitDTO;

import java.util.List;

public interface TwitService {

    public void save(TwitDTO twit);

    public List<TwitDTO> getTwits();
}
