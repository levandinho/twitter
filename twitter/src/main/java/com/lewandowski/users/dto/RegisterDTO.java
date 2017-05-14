package com.lewandowski.users.dto;

import com.lewandowski.twits.dto.TwitDTO;
import com.lewandowski.users.util.UserModuleConstants;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterDTO {

    @NotEmpty
    @Size(max = UserModuleConstants.USERNAME_MAX_SIZE, min= UserModuleConstants.USERNAME_MIN_SIZE)
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
}