package my.edu.um.fsktm.cra.amazonreviewcollector.service;

import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;

import java.time.LocalDate;
import java.util.List;

public interface ReviewService {
    public void saveReview(String productId, LocalDate reviewStartDate);
    public void sendReviewCollectedMessage(String productId, List<Review> reviews);
    public void publishCollectedReview(Review review);
}
