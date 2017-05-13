package com.lewandowski.user.dto;

import com.lewandowski.user.entity.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 32112233L;

    private String name;

    public UserDTO(User author) {
        this.name = author.getUsername();
    }

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
