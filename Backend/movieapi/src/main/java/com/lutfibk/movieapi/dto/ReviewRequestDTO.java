package com.lutfibk.movieapi.dto;


public class ReviewRequestDTO {
    private String reviewBody;
    private String ImdbId;

    public String getReviewBody() {
        return reviewBody;
    }

    public void setReviewBody(String reviewBody) {
        this.reviewBody = reviewBody;
    }

    public String getImdbId() {
        return ImdbId;
    }

    public void setImdbId(String imdbId) {
        ImdbId = imdbId;
    }
}
