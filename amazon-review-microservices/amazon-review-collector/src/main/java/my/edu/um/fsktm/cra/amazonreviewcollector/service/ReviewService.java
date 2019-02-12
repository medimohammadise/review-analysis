package my.edu.um.fsktm.cra.amazonreviewcollector.service;

import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;
import my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging.ReviewEvent;

import java.time.LocalDate;
import java.util.List;

public interface ReviewService {
    public void extractAndsaveReview(String productId,String channelURL, LocalDate reviewStartDate);
    public void sendReviewCollectedMessage(String productId, List<Review> reviews);
    public void publishCollectedReview(Review review);

    void saveReview(ReviewEvent analysedReview);
    void deleteAll();
}
