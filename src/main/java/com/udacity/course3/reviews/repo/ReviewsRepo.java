package com.udacity.course3.reviews.repo;

import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewsRepo extends CrudRepository<Review, Long> {
    List<Review> findByProductId(long id);

}
