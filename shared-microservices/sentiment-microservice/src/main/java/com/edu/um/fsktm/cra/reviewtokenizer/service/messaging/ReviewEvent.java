package com.edu.um.fsktm.cra.reviewtokenizer.service.messaging;

import java.time.LocalDate;
import java.util.List;

public class ReviewEvent {
	private String reviewId;
    private LocalDate eventDate;
    private double sentiment ;
    private List<String> posTagList;
    public ReviewEvent(){

    }
    public ReviewEvent(LocalDate eventDate, String reviewId, double sentiment,List<String> posTagList) {
        this.reviewId = reviewId;
        this.eventDate = eventDate;
        this.sentiment = sentiment;
        this.posTagList=posTagList;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }


    public void setEventDateTime(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public double getSentiment() {
        return sentiment;
    }

    public void setSentiment(double sentiment) {
        this.sentiment = sentiment;
    }

    public List<String> getPosTagList() {
        return posTagList;
    }

    public void setPosTagList(List<String> posTagList) {
        this.posTagList = posTagList;
    }
}
