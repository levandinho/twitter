package com.lewandowski.twits.entity;

import com.lewandowski.twits.util.TwitModuleConstants;
import com.lewandowski.users.entity.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Twit {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(max = 140, message = TwitModuleConstants.INVALID_SIZE)
    private String message;

    @ManyToOne
    private User author;

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date dateAdded;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Twit)) return false;

        Twit twit = (Twit) o;

        if (author != null ? !author.equals(twit.author) : twit.author != null) return false;
        if (dateAdded != null ? !dateAdded.equals(twit.dateAdded) : twit.dateAdded != null) return false;
        if (id != null ? !id.equals(twit.id) : twit.id != null) return false;
        if (message != null ? !message.equals(twit.message) : twit.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (dateAdded != null ? dateAdded.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Twit{" +
                "message='" + message + '\'' +
                ", author=" + author +
                ", dateAdded=" + dateAdded +
                '}';
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDateAdded() {
        return dateAdded;
    }
}
