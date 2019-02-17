package my.edu.um.fsktm.cra.amazonreviewhousekeeper.domain;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import com.couchbase.client.java.repository.annotation.Field;
@Document
public class ReviewCollectionHistory {
    @Id
    @Field
    public long productId;

    @Field
    public LocalDate reviewCollectionDate;

    @Field
    public long numberOfColelctedReviews;

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public LocalDate getReviewCollectionDate() {
        return reviewCollectionDate;
    }

    public void setReviewCollectionDate(LocalDate reviewCollectionDate) {
        this.reviewCollectionDate = reviewCollectionDate;
    }

    public long getNumberOfColelctedReviews() {
        return numberOfColelctedReviews;
    }

    public void setNumberOfColelctedReviews(long numberOfColelctedReviews) {
        this.numberOfColelctedReviews = numberOfColelctedReviews;
    }
}
