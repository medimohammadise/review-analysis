package com.edu.um.fsktm.cra.reviewtokenizer.web.rest.dto;

import com.couchbase.client.java.repository.annotation.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

public class Review implements Serializable {

    private static final long serialVersionUID = 1L;
    public Review(){

    }
    public Review(String id, String productId, String customerProfileId, String title, String author, String reviewText, String reviewDate) {
    	  this.id=id;
    	  this.customerProfileId=customerProfileId;
    	  this.title=title;
    	  this.author=author;
    	  this.reviewText=reviewText;
    	  this.reviewDate=reviewDate;
    	  this.productId=productId;
    }

    private String id;
    

    private String productId;
    

    private String title;
    
    

    private String author;
    

    private String reviewText;

    private String customerProfileId;
    

    private String reviewDate;
    private double sentiment;

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

	public double getSentiment() {
		return sentiment;
	}

	public void setSentiment(double sentiment) {
		this.sentiment = sentiment;
	}
}
