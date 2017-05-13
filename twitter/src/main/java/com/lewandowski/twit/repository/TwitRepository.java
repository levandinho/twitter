package com.lewandowski.twit.repository;

import com.lewandowski.twit.entity.Twit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TwitRepository  extends JpaRepository<Twit, Long> {

}
