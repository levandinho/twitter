package com.lewandowski.users.dto;

import com.lewandowski.twits.dto.TwitDTO;
import com.lewandowski.users.util.UserModuleConstants;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterDTO {

    @NotEmpty
    @Size(min = UserModuleConstants.USERNAME_MIN_SIZE, max = UserModuleConstants.USERNAME_MAX_SIZE, message = UserModuleConstants.INVALID_USERNAME)
    private String username;

    private TwitDTO firstTwit;

    public RegisterDTO() {
    }

    public RegisterDTO(String username, TwitDTO firstTwit) {
        this.username = username;
        this.firstTwit = firstTwit;
    }

    public String getUsername() {
        return username;
    }

    public TwitDTO getFirstTwit() {
        return firstTwit;
    }

    @Override
    public String toString() {
        return "RegisterDTO{" +
                "username='" + username + '\'' +
                ", firstTwit=" + firstTwit +
                '}';
    }
}
