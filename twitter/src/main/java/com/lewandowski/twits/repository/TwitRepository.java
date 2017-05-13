package com.lewandowski.twits.repository;

import com.lewandowski.twits.entity.Twit;
import com.lewandowski.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TwitRepository  extends JpaRepository<Twit, Long> {

    public List<Twit> findByAuthorIdOrderByDateAddedDesc(Long id);

    List<Twit> findByAuthorInOrderByDateAddedDesc(List<User> followees);
}
