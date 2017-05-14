package com.lewandowski.twits.service.impl;

import com.lewandowski.twits.entity.Twit;
import com.lewandowski.twits.repository.TwitRepository;
import com.lewandowski.twits.service.TwitService;
import com.lewandowski.users.entity.User;
import com.lewandowski.users.repository.UserRepository;
import com.lewandowski.users.service.UserService;
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
    public Twit save(Twit twit) {
        twitRepository.save(twit);
        return twit;
    }

    @Override
    public List<Twit> getTwitsForUser(Long userId) {
        List<Twit> twits = twitRepository.findByAuthorIdOrderByDateAddedDesc(userId);
        return twits;
    }

    @Override
    public void delete(Long id) {
        twitRepository.delete(id);
    }

    @Override
    public Twit getTwit(Long id) {
        return twitRepository.getOne(id);
    }
}
