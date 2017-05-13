package com.lewandowski.twit.service.impl;

import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.twit.entity.Twit;
import com.lewandowski.twit.repository.TwitRepository;
import com.lewandowski.twit.service.TwitService;
import com.lewandowski.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class TwitServiceImpl implements TwitService {

    @Autowired
    private TwitRepository twitRepository;

    @Override
    public void save(TwitDTO twitDTO) {

    }

    @Override
    public List<TwitDTO> getTwits() {
        List<Twit> twits = twitRepository.findAll();
        //TODO: maybe Orika Mapper for more complicated cases?
        List<TwitDTO> results = twits.stream().map(t -> new TwitDTO(t.getId(), t.getMessage(), new UserDTO(t.getAuthor()))).collect(Collectors.toList());
        return results;
    }
}
