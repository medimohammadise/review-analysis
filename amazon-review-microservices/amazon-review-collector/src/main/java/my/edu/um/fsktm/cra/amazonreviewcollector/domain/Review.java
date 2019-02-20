package my.edu.um.fsktm.cra.amazonreviewcollector.domain;

import com.couchbase.client.java.repository.annotation.Field;
import my.edu.um.fsktm.cra.amazonreviewcollector.enumeration.ECommerceChannel;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.couchbase.core.mapping.id.GenerationStrategy.UNIQUE;

/**
 *  Review.
 */
@Document
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = UNIQUE)
	@Field
	private String id;


	@Field
	private String productId;

	@Field
	private String title;


	@Field
	private String author;

	@Field
	private String reviewText;

	private String  reviewContent;

	@Field
	private String customerProfileId;

	@Field
	private String reviewDate;

	@Field
	private Double sentiment;

	@Field
	private ECommerceChannel channel;



	@Field
	private List<String> postTags;

	public Review(){

	}
    public Review(ECommerceChannel channel, String productId, String customerProfileId, String title, String author, String reviewText,
				  String reviewDate, double sentiment ) {
    	  this.id=UUID.randomUUID().toString();
    	  this.channel=channel;
    	  this.customerProfileId=customerProfileId;
    	  this.title=title;
    	  this.author=author;
    	  this.reviewText=reviewText;
    	  this.reviewDate=reviewDate;
    	  this.productId=productId;
    	  this.sentiment=sentiment;
    }


	public String getId() {
		return id;
	}

	public void setId(Long id) {
		this.id =  UUID.randomUUID().toString();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getReviewText() {
		return reviewText;
	}

	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}

	public String getCustomerProfileId() {
		return customerProfileId;
	}

	public void setCustomerProfileId(String customerProfileId) {
		this.customerProfileId = customerProfileId;
	}

	public String getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(String reviewDate) {
		this.reviewDate = reviewDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Double getSentiment() {
		return sentiment;
	}

	public void setSentiment(Double sentiment) {
		this.sentiment = sentiment;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public ECommerceChannel getChannel() {
		return channel;
	}

	public void setChannel(ECommerceChannel channel) {
		this.channel = channel;
	}
	public List<String> getPostTags() {
		return postTags;
	}

	public void setPostTags(List<String> postTags) {
		this.postTags = postTags;
	}
}
