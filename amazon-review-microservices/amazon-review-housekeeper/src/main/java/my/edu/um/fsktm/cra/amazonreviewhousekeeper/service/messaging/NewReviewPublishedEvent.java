package my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NewReviewPublishedEvent {
	private String productId;
    private String channelURL;
    private LocalDateTime eventDateTime;
    private LocalDateTime newReviewStartDateTime ;

    public NewReviewPublishedEvent(String productId,String channelURL, LocalDateTime eventDateTime, LocalDateTime newReviewStartDateTime) {
        this.productId = productId;
        this.channelURL=channelURL;
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

    public String getChannelURL() {
        return channelURL;
    }

    public void setChannelURL(String channelURL) {
        this.channelURL = channelURL;
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
