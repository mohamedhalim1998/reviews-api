package com.udacity.course3.reviews.entity;

import javax.persistence.*;

@Entity(name = "COMMENTS")
@Table(name = "COMMENTS")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "reviewId", unique = true)
    private long reviewId;
    @Column(name = "comment", unique = true)
    private String comment;

    public Comment(long id, long reviewId, String comment) {
        this.id = id;
        this.reviewId = reviewId;
        this.comment = comment;
    }

    public Comment(long reviewId, String comment) {
        this.reviewId = reviewId;
        this.comment = comment;
    }

    public Comment(String comment) {
        this.comment = comment;
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", reviewId=" + reviewId +
                ", comment='" + comment + '\'' +
                '}';
    }
}
