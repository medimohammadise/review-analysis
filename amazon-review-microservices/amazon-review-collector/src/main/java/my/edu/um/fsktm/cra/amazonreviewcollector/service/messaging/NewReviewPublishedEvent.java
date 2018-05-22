package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;

public class NewReviewPublishedEvent {
	public String productId;
	public NewReviewPublishedEvent() {
		
	}
	public NewReviewPublishedEvent(String productId){
		this.productId=productId;
	}
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ProductId"+productId;
	}
	

}
