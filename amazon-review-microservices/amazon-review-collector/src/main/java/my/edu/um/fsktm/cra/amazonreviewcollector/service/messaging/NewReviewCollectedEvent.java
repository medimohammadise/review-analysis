package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewReviewCollectedEvent {
	public String productId;
    public LocalDateTime eventDateTime;
    public LocalDateTime newReviewStartDateTime ;
    public long numberOfReviews;
    public NewReviewCollectedEvent(){

    }


    public NewReviewCollectedEvent(String productId, LocalDateTime eventDateTime, LocalDateTime newReviewStartDateTime, long numberOfReviews) {
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

    public LocalDateTime getNewReviewStartDateTime() {
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

    public void setNewReviewStartDateTime(LocalDateTime newReviewStartDateTime) {
        this.newReviewStartDateTime = newReviewStartDateTime;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
}
