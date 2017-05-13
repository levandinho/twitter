package com.lewandowski.users.repository;

import com.lewandowski.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    public List<User> findByUsernameLike(String username);
}
