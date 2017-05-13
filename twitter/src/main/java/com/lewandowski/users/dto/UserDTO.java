package com.lewandowski.users.dto;

import com.lewandowski.users.entity.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 32112233L;

    private Long id;

    private String name;

    public UserDTO(User author) {
        this.name = author.getUsername();
        this.id = author.getId();
    }

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
