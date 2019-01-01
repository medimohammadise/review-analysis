package com.edu.um.fsktm.cra.reviewtokenizer.service.messaging;


import com.edu.um.fsktm.cra.reviewtokenizer.service.SentimentService;
import com.edu.um.fsktm.cra.reviewtokenizer.web.rest.dto.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class CosnumerService {
     SentimentService sentimentService;
	 private final Logger log = LoggerFactory.getLogger(getClass());
	 	public CosnumerService(SentimentService sentimentService
                                ) {
	 		this.sentimentService=sentimentService;
	 	}

	 	@StreamListener(ConsumerChannel.NEW_REVIEW_CHANNEL)
	    public void consume(Review review) {
	        log.info("Received message in sentiment microservice: {}.", review.getId());
            sentimentService.sentiment(review.getReviewText());
	    }

	   /*@StreamListener(ConsumerChannel.CHANNEL)
	    public void consume(@Input(ConsumerChannel.CHANNEL) KStream<String,NewReviewPublishedEvent> newReviewPublishedEvent ) {
	    		//newReviewPublishedEvent.flatMap(arg0)
	    	    log.info("successfully created connected to steam of new reviews");



           newReviewPublishedEvent.map((k, v) ->  {
               log.info("Key: " + k + " value: " + v.getEventDateTime());
               return new KeyValue<>(k, v);
           });

	        //reviewService.saveReview(readyToCollectReview.getProductId());
	    }*/
}
