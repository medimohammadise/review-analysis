package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;

import java.time.LocalDate;

public class ReviewEvent {
	public String productId;
    public LocalDate eventDate;
    public double sentiment ;
    public ReviewEvent(){

    }
    public ReviewEvent(LocalDate eventDate, String productId, double sentiment) {
        this.productId = productId;
        this.eventDate = eventDate;
        this.sentiment = sentiment;
    }

	public String getProductId() {
		return productId;
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
