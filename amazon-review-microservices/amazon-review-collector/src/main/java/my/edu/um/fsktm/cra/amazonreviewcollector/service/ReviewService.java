package my.edu.um.fsktm.cra.amazonreviewcollector.service;

import com.couchbase.client.deps.com.fasterxml.jackson.databind.JsonNode;
import com.couchbase.client.java.document.json.JsonObject;
import my.edu.um.fsktm.cra.amazonreviewcollector.domain.Review;
import my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging.ReviewEvent;
import my.edu.um.fsktm.cra.amazonreviewcollector.web.rest.dto.InterviewAnalyticsDTO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReviewService {
    public void extractAndsaveReview(String productId,String channelURL, LocalDateTime reviewStartDate);
    public void sendReviewCollectedMessage(String productId, List<Review> reviews);
    public void publishCollectedReview(Review review);

    void saveReview(ReviewEvent analysedReview);
    void deleteAll();
    List<InterviewAnalyticsDTO>   findAvarageSentimentByMonth();
}

