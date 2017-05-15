package com.lewandowski.users.entity;

import com.lewandowski.tweets.entity.Tweet;
import com.lewandowski.users.util.UserModuleConstants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = UserModuleConstants.USERNAME_NULL)
    @Size(min = UserModuleConstants.USERNAME_MIN_SIZE, max = UserModuleConstants.USERNAME_MAX_SIZE, message = UserModuleConstants.INVALID_USERNAME)
    @Column(unique = true)
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<User> followees;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    @OrderBy("dateAdded DESC")
    private List<Tweet> tweets;

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<User> getFollowees() {
        return followees;
    }

    public void setFollowees(Set<User> followees) {
        this.followees = followees;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!username.equals(user.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
