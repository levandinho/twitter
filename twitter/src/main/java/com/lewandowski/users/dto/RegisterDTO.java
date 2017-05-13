package com.lewandowski.users.dto;

import com.lewandowski.twits.dto.TwitDTO;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterDTO {

    @NotEmpty
    @Size(max = 25)
    private String username;
    {}
    private TwitDTO firstTwit;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public TwitDTO getFirstTwit() {
        return firstTwit;
    }

    public void setFirstTwit(TwitDTO firstTwit) {
        this.firstTwit = firstTwit;
    }
}
