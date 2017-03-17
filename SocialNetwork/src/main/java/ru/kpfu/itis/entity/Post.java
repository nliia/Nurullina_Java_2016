package ru.kpfu.itis.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@SequenceGenerator(name = "seq", sequenceName = "post_id_uniq", initialValue = 53, allocationSize = 1)

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    public Post(String text, Date date, User author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public Post() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
