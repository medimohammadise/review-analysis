package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;


import org.slf4j.LoggerFactory;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import my.edu.um.fsktm.cra.amazonreviewcollector.service.ReviewService;

@Service
public class CosnumerService {
	 ReviewService reviewService;
	 private final Logger log = LoggerFactory.getLogger(getClass());
	 	public CosnumerService(ReviewService reviewService) {
	 		this.reviewService=reviewService;
	 	}

	 	@StreamListener(ConsumerChannel.NEW_REVIEW_CHANNEL)
	    public void consume(NewReviewPublishedEvent newReviewPublishedEvent) {
	        log.info("Received message: {}.", newReviewPublishedEvent.getProductId());
            reviewService.saveReview(newReviewPublishedEvent.getProductId(),newReviewPublishedEvent.getChannelURL(),newReviewPublishedEvent.getNewReviewStartDateTime());
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
