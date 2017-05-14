package com.lewandowski.users.dto;

import com.lewandowski.users.entity.User;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 32112233L;

    private Long id;

    @NotEmpty
    private String username;

    public UserDTO(User author) {
        this.username = author.getUsername();
        this.id = author.getId();
    }

    public UserDTO(String username, Long id) {
        this.username = username;
        this.id = id;
    }

    public UserDTO() {
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }
}
