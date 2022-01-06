package com.udacity.course3.reviews.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "REVIEWS")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long productId;
    private String review;

    @OneToMany
//    @JoinTable(
//            name = "COMMENTS",
//            joinColumns = {@JoinColumn(name = "reviewId", referencedColumnName = "id")}
//    )

    @JoinColumn(name = "reviewId", referencedColumnName = "id")
    // While Update this will also insert collection row another insert
    private List<Comment> comments;

    public Review() {
    }


    public Review(long id, long productId, String review) {
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
        if(comments == null){
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }
}
