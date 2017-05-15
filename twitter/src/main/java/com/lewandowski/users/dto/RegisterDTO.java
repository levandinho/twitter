package com.lewandowski.users.dto;

import com.lewandowski.tweets.dto.TweetDTO;
import com.lewandowski.users.util.UserModuleConstants;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterDTO {

    @NotEmpty(message = UserModuleConstants.USERNAME_NULL)
    @Size(min = UserModuleConstants.USERNAME_MIN_SIZE, max = UserModuleConstants.USERNAME_MAX_SIZE, message = UserModuleConstants.INVALID_USERNAME)
    private String username;

    @NotNull(message = UserModuleConstants.FIRST_TWEET_MANDATORY)
    private TweetDTO firstTweet;

    public RegisterDTO() {
    }

    public RegisterDTO(String username, TweetDTO firstTweet) {
        this.username = username;
        this.firstTweet = firstTweet;
    }

    public String getUsername() {
        return username;
    }

    public TweetDTO getFirstTweet() {
        return firstTweet;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "username='" + username + '\'' +
                ", firstTweet=" + firstTweet +
                '}';
    }
}
