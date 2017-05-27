package com.gluuten.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yusufaslan on 25.05.2017.
 */
@Entity
@Table(name = "comments")
public class Comment implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String commentBody;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comment_sender_id")
    @Column
    private Person commentSender;

    @Column
    private Date commentDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    @Column
    private Post commentOfPost;

    public Comment(String commentBody, Person commentSender, Date commentDate, Post commentOfPost) {
        this.commentBody = commentBody;
        this.commentSender = commentSender;
        this.commentDate = commentDate;
        this.commentOfPost = commentOfPost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public void setCommentBody(String commentBody) {
        this.commentBody = commentBody;
    }

    public Person getCommentSender() {
        return commentSender;
    }

    public void setCommentSender(Person commentSender) {
        this.commentSender = commentSender;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Post getCommentOfPost() {
        return commentOfPost;
    }

    public void setCommentOfPost(Post commentOfPost) {
        this.commentOfPost = commentOfPost;
    }
}
