package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;


import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import my.edu.um.fsktm.cra.amazonreviewcollector.service.ReviewService;
@Service
public class CosnumerService {
	 ReviewService reviewService;
	 private final Logger log = LoggerFactory.getLogger(CosnumerService.class);
	 	public CosnumerService(ReviewService reviewService) {
	 		this.reviewService=reviewService;
	 	}
	    @StreamListener(ConsumerChannel.CHANNEL)
	    public void consume(ReadyToCollectReview readyToCollectReview) {
	    	    log.info("recived product is "+readyToCollectReview);
	        log.info("Review for Product Id  is ready to collect", readyToCollectReview.getProductId());
	        reviewService.saveReview(readyToCollectReview.getProductId());
	    }
}
