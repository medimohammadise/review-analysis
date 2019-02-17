package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;

import java.time.LocalDate;

public class ReviewEvent {
	public String reviewId;
    public LocalDate eventDate;
    public double sentiment ;
    public ReviewEvent(){

    }
    public ReviewEvent(LocalDate eventDate, String reviewId, double sentiment) {
        this.reviewId = reviewId;
        this.eventDate = eventDate;
        this.sentiment = sentiment;
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
}
