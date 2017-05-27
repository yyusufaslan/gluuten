package com.gluuten.entities;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by yusufaslan on 25.05.2017.
 */
@Entity
@Table(name = "posts")
public class Post implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date postDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_sender_id")
    @Column
    private Person postSender;

    @Column(nullable = false)
    private String postTitle;

    @Column(nullable = false)
    private String postBody;

    @Column
    private String postImage;

    public Post(Date postDate, Person postSender,String postTitle, String postBody, String postImage) {
        this.postDate = postDate;
        this.postTitle = postTitle;
        this.postSender = postSender;
        this.postBody = postBody;
        this.postImage = postImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Person getPostSender() {
        return postSender;
    }

    public void setPostSender(Person postSender) {
        this.postSender = postSender;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostBody() {
        return postBody;
    }

    public void setPostBody(String postBody) {
        this.postBody = postBody;
    }

    public String getPostImage() {
        return postImage;
    }

    public void setPostImage(String postImage) {
        this.postImage = postImage;
    }
}
