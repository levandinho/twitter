package com.lewandowski.user.dto;

import java.io.Serializable;

public class UserDTO  implements Serializable {

    private static final long serialVersionUID = 32112233L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
