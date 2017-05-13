package com.lewandowski.twits.dto;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;

public class TwitDTO implements Serializable {

    private static final long serialVersionUID = 32134123L;

    private Long id;
    @Size(max = 140, message = "com.lewandowski.twits.dto.TwitDTO.invalidSize")
    @NotEmpty
    private String message;

    private Long authorId;

    public TwitDTO() {
    }

    public TwitDTO(Long id, String message, Long author) {
        this.id = id;
        this.message = message;
        this.authorId = author;
    }

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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long author) {
        this.authorId = author;
    }
}
