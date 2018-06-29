package my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewReviewPublishedEvent {
	public String productId;
    public LocalDateTime eventDateTime;
    public LocalDate newReviewStartDateTime ;

    public NewReviewPublishedEvent(String productId, LocalDateTime eventDateTime, LocalDate newReviewStartDateTime) {
        this.productId = productId;
        this.eventDateTime = eventDateTime;
        this.newReviewStartDateTime = newReviewStartDateTime;
    }

	public String getProductId() {
		return productId;
	}

	public String setProductId(String productId) {
		this.productId = productId;
		return this.productId;
	}

    public LocalDateTime getEventDateTime() {
        return eventDateTime;
    }

    public LocalDate getNewReviewStartDateTime() {
        return newReviewStartDateTime;
    }

    public void setEventDateTime(LocalDateTime eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public void setNewReviewStartDateTime(LocalDate newReviewStartDateTime) {
        this.newReviewStartDateTime = newReviewStartDateTime;
    }
}
