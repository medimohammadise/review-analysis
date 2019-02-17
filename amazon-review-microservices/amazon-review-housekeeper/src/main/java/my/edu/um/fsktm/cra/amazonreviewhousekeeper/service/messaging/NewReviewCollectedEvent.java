package my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewReviewCollectedEvent {
	public String productId;
    public LocalDateTime eventDateTime;
    public LocalDate newReviewStartDateTime ;
    public long numberOfReviews;
    public NewReviewCollectedEvent(){

    }


    public NewReviewCollectedEvent(String productId, LocalDateTime eventDateTime, LocalDate newReviewStartDateTime, long numberOfReviews) {
        this.productId = productId;
        this.eventDateTime = eventDateTime;
        this.newReviewStartDateTime = newReviewStartDateTime;
        this.numberOfReviews=numberOfReviews;
    }

	public String getProductId() {
		return productId;
	}

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public LocalDate getNewReviewStartDateTime() {
        return newReviewStartDateTime;
    }

    public long getNumberOfReviews() {
        return numberOfReviews;
    }
    public void setNumberOfReviews(long numberOfReviews) {
        this.numberOfReviews = numberOfReviews;
    }
    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public void setNewReviewStartDateTime(LocalDate newReviewStartDateTime) {
        this.newReviewStartDateTime = newReviewStartDateTime;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
