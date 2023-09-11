package com.lutfibk.movieapi.service;

import com.lutfibk.movieapi.model.Movie;
import com.lutfibk.movieapi.model.Review;
import com.lutfibk.movieapi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository; //reference to the review Repo

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public Review createReview(String reviewBody, String ImdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)//we are using the template to perform an update on the movie class
                .matching(Criteria.where("imdbId").is(ImdbId)) //which movie are we updating matching the imdbId provided by the user
                .apply(new Update().push("reviewIds").value(review)) //update the review ids and the value will be the review we just create
                .first();

        return review;
    }
}
