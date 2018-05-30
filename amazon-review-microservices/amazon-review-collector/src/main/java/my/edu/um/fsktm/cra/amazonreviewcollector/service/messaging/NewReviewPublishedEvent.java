package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;

import java.time.LocalDateTime;

public class NewReviewPublishedEvent {
	public String productId;
    public LocalDateTime eventDateTime;
    public LocalDateTime newReviewStartDateTime ;
    public NewReviewPublishedEvent(){

    }
    public NewReviewPublishedEvent(String productId, LocalDateTime eventDateTime, LocalDateTime newReviewStartDateTime) {
        this.productId = productId;
        this.eventDateTime = eventDateTime;
        this.newReviewStartDateTime = newReviewStartDateTime;
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

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public void setNewReviewStartDateTime(LocalDateTime newReviewStartDateTime) {
        this.newReviewStartDateTime = newReviewStartDateTime;
    }
}
