package com.lutfibk.movieapi.controller;

import com.lutfibk.movieapi.dto.ReviewRequestDTO;
import com.lutfibk.movieapi.model.Review;
import com.lutfibk.movieapi.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody ReviewRequestDTO reviewRequest){
        return new ResponseEntity<Review>(
                reviewService.createReview(reviewRequest.getReviewBody(), reviewRequest.getImdbId()),
                HttpStatus.CREATED);
    }
}
