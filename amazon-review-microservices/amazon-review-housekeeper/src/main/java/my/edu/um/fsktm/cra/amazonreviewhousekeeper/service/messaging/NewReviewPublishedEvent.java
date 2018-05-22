package my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging;

public class NewReviewPublishedEvent {
	public String productId;
	public NewReviewPublishedEvent(String productId){
		this.productId = productId;
	}

	public String getProductId() {
		return productId;
	}

	public String setProductId(String productId) {
		this.productId = productId;
		return this.productId;
	}

}
