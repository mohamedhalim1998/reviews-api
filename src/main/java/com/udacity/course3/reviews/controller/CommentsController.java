package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repo.CommentRepo;
import com.udacity.course3.reviews.repo.ReviewsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    // TODO: Wire needed JPA repositories here
    @Autowired
    private ReviewsRepo reviewsRepo;
    @Autowired
    private CommentRepo commentRepo;

    /**
     * Creates a comment for a review.
     * <p>
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Integer reviewId, @RequestBody Comment comment) {
        Optional<Review> review = reviewsRepo.findById((long) reviewId);
        System.out.println(comment);
        if (review.isPresent()) {
            comment.setReviewId(reviewId);
//            List<Comment> comments = new ArrayList<>(review.get().getComments());
            commentRepo.save(comment);
//            comments.add(comment);
//            review.get().setReview("edit review");
//            review.get().setComments(comments);
//            reviewsRepo.save(review.get());
            return ResponseEntity.ok(comment);
        }
        throw new RuntimeException("Review Not Found");
    }

    /**
     * List comments for a review.
     * <p>
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        if (reviewsRepo.findById((long) reviewId).isPresent()) {
            return commentRepo.findByReviewId(reviewId);
        }
        throw new RuntimeException("Review not found");
    }
}