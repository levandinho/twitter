package com.lewandowski.twit.entity;

import com.lewandowski.user.entity.User;

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
    @Size(max = 140,message = "com.lewandowski.twit.entity.Twit.invalidSize")
    private String message;

    @ManyToOne
    @NotNull
    private User author;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    private Date dateAdded;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Twit)) return false;

        Twit twit = (Twit) o;

        if (!author.equals(twit.author)) return false;
        if (!dateAdded.equals(twit.dateAdded)) return false;
        if (!message.equals(twit.message)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = message.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + dateAdded.hashCode();
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

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
}
