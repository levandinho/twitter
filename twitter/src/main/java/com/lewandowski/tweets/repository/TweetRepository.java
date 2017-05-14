package com.lewandowski.tweets.repository;

import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface TweetRepository  extends JpaRepository<Tweet, Long> {

    public List<Tweet> findByAuthorIdOrderByDateAddedDesc(Long id);

    List<Tweet> findByAuthorInOrderByDateAddedDesc(Set<User> followees);
}
