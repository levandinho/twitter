package com.lewandowski.twit.repository;

import com.lewandowski.twit.entity.Twit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TwitRepository  extends JpaRepository<Twit, Long> {

    public List<Twit> findByAuthorIdOrderByDateAddedDesc(Long id);

}
