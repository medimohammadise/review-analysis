package my.edu.um.fsktm.cra.amazonreviewcollector.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;

/**
 *  Review.
 */
@Document
public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    public Review(String customerProfileId,String title,String author,String reviewText,LocalDate reviewDate) {
    	  this.id=UUID.randomUUID().toString();
    	  this.customerProfileId=customerProfileId;
    	  this.title=title;
    	  this.author=author;
    	  this.reviewText=reviewText;
    	  this.reviewDate=reviewDate;
    }
    @Id
    @Field
    private String id;

    @Field
    private String title;
    
    
    @Field
    private String author;
    
    @Field
    private String reviewText;
    
    @Field
    private String customerProfileId;
    
    @Field
    private LocalDate reviewDate;
    

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

	public LocalDate getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(LocalDate reviewDate) {
		this.reviewDate = reviewDate;
	}

	public void setId(String id) {
		this.id = id;
	}

  
  
}
