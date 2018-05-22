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


//@EnableBinding(ConsumerChannel.class)
public class CosnumerService {
	 ReviewService reviewService;
	 private final Logger log = LoggerFactory.getLogger(getClass());
	 	public CosnumerService(ReviewService reviewService) {
	 		this.reviewService=reviewService;
	 	}
	 
	 	@StreamListener(ConsumerChannel.CHANNEL)
	    public void consume(NewReviewPublishedEvent greeting) {
	        log.info("Received message: {}.", greeting.getProductId());
	    }
	 	
	   /*@StreamListener(ConsumerChannel.CHANNEL)
	    public void consume(@Input(ConsumerChannel.CHANNEL) KStream<?,?> newReviewPublishedEvent ) {
	    		//newReviewPublishedEvent.flatMap(arg0)
	    	    log.info("recived product is *****"+newReviewPublishedEvent.toString());
	        //log.info("Review for Product Id  is ready to collect", readyToCollectReview.getProductId());
	        //reviewService.saveReview(readyToCollectReview.getProductId());
	    }*/
}
