package com.lewandowski.twit.dto;

import com.lewandowski.user.dto.UserDTO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class TwitDTO implements Serializable {

    private static final long serialVersionUID = 32134123L;

    public TwitDTO(Long id, String message, UserDTO author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }

    private Long id;
    @Size(max = 140, message = "com.lewandowski.twit.dto.TwitDTO.invalidSize")
    @NotEmpty
    private String message;

    private UserDTO author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }
}
