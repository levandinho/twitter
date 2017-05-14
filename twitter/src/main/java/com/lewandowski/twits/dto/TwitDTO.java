package com.lewandowski.twits.dto;

import com.lewandowski.twits.util.TwitModuleConstants;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class TwitDTO implements Serializable {

    private static final long serialVersionUID = 32134123L;

    private Long id;

    @Size(max = 140, message = TwitModuleConstants.INVALID_SIZE)
    @NotEmpty
    private String message;

    private Long authorId;

    private Date dateAdded;

    public TwitDTO() {
    }

    public TwitDTO(Long id, String message, Long author, Date dateAdded) {
        this.id = id;
        this.message = message;
        this.authorId = author;
        this.dateAdded = dateAdded;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    @Override
    public String toString() {
        return "TwitDTO{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", authorId=" + authorId +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
