package com.lewandowski.tweets.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lewandowski.commons.JsonDateSerializer;
import com.lewandowski.tweets.util.TweetModuleConstants;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class TweetDTO implements Serializable {

    private static final long serialVersionUID = 32134123L;

    private Long id;

    @Size(max = 140, message = TweetModuleConstants.INVALID_SIZE)
    @NotEmpty(message = TweetModuleConstants.NOT_EMPTY_MESSAGE)
    private String message;

    private Long authorId;

    @JsonSerialize(using=JsonDateSerializer.class)
    private Date dateAdded;

    public TweetDTO() {
    }

    public TweetDTO(Long id, String message, Long author, Date dateAdded) {
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
        return "TweetDTO{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", authorId=" + authorId +
                ", dateAdded=" + dateAdded +
                '}';
    }
}
