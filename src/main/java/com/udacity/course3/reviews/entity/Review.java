package com.udacity.course3.reviews.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Document("reviews")
public class Review {
    @Id
    private String id;
    private long productId;
    private String review;


    private List<Comment> comments = new ArrayList<>();

    public Review() {
    }


    public Review(String id, long productId, String review) {
        this.id = id;
        this.productId = productId;
        this.review = review;
    }

    public Review(long productId, String review) {
        this.productId = productId;
        this.review = review;
    }

    public Review(String review) {
        this.review = review;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment comment) {

        comments.add(comment);
    }
}
