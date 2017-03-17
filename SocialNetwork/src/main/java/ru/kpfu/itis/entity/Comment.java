package ru.kpfu.itis.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post_comments")
@SequenceGenerator(name = "seq", sequenceName = "comment_id_uniq", initialValue = 53, allocationSize = 1)

public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private Post post;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Comment() {

    }

    public Comment(String text, User author, Post post, Date date) {
        this.text = text;
        this.author = author;
        this.post = post;
        this.date = date;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
