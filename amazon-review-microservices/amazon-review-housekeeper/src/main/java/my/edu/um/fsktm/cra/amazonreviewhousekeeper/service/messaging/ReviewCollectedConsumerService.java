package my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging;


import my.edu.um.fsktm.cra.amazonreviewhousekeeper.domain.ReviewCollectionHistory;
import my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.ReviewHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class ReviewCollectedConsumerService {
	 ReviewHistoryService reviewHistoryService;
	 private final Logger log = LoggerFactory.getLogger(getClass());
	 	public ReviewCollectedConsumerService(ReviewHistoryService reviewHistoryService) {
	 		this.reviewHistoryService=reviewHistoryService;
	 	}

	 	@StreamListener(ConsumerChannel.CHANNEL)
	    public void consume(NewReviewCollectedEvent newReviewCollectedEvent) {
	        log.info("Received message from review collection report channel", newReviewCollectedEvent.getProductId());
            ReviewCollectionHistory reviewCollectionHistory= new ReviewCollectionHistory();
            //reviewCollectionHistory.setProductId(newReviewCollectedEvent.productId);
            newReviewCollectedEvent.setNumberOfReviews(newReviewCollectedEvent.numberOfReviews);
            reviewHistoryService.saveReviewHistory(reviewCollectionHistory);
	    }
}
