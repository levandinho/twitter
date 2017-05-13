package com.lewandowski.twit.service.impl;

import com.lewandowski.twit.dto.TwitDTO;
import com.lewandowski.twit.entity.Twit;
import com.lewandowski.twit.repository.TwitRepository;
import com.lewandowski.twit.service.TwitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TwitServiceImpl implements TwitService {

    @Autowired
    private TwitRepository twitRepository;

    @Override
    public long save(Twit twit) {
        twitRepository.save(twit);
        return twit.getId();
    }

    @Override
    public List<Twit> getTwits() {
        List<Twit> twits = twitRepository.findAll();
        return twits;
    }

    @Override
    public Twit getTwit(Long id) {
        return twitRepository.getOne(id);
    }
}
