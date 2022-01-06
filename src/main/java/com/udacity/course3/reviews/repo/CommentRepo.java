package com.udacity.course3.reviews.repo;

import com.udacity.course3.reviews.entity.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepo extends CrudRepository<Comment, Long> {
    List<Comment> findByReviewId(long id);
}
