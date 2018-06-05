package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewReviewPublishedEvent {
	public String productId;
    public LocalDate eventDate;
    public LocalDate newReviewStartDate ;
    public NewReviewPublishedEvent(){

    }
    public NewReviewPublishedEvent(String productId, LocalDate eventDate, LocalDate newReviewStartDate) {
        this.productId = productId;
        this.eventDate = eventDate;
        this.newReviewStartDate = newReviewStartDate;
    }

	public String getProductId() {
		return productId;
	}

    public LocalDate getEventDate() {
        return eventDate;
    }

    public LocalDate getNewReviewStartDate() {
        return newReviewStartDate;
    }

    public void setEventDateTime(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public void setNewReviewStartDateTime(LocalDate newReviewStartDate) {
        this.newReviewStartDate = newReviewStartDate;
    }
}
