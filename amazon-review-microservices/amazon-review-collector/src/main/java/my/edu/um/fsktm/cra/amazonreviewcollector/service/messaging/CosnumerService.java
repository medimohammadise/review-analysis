package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;


import my.edu.um.fsktm.cra.amazonreviewcollector.service.ReviewService;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Service
public class CosnumerService {
	 ReviewService reviewService;
	 private final Logger log = LoggerFactory.getLogger(getClass());
	 	public CosnumerService(ReviewService reviewService) {
	 		this.reviewService=reviewService;
	 	}

	 	/*@StreamListener(ConsumerChannel.CHANNEL)
	    public void consume(NewReviewPublishedEvent greeting) {
	        log.info("Received message: {}.", greeting.getProductId());
	    }*/

	   @StreamListener(ConsumerChannel.CHANNEL)
	    public void consume(@Input(ConsumerChannel.CHANNEL) KStream<?,?> newReviewPublishedEvent ) {
	    		//newReviewPublishedEvent.flatMap(arg0)
	    	    log.info("recived product is *****"+newReviewPublishedEvent.toString());
           newReviewPublishedEvent.map((k, v) -> {
               log.info("Key: " + k + " value: " + v);
               return new KeyValue<>(k, v);
           });

	        //reviewService.saveReview(readyToCollectReview.getProductId());
	    }
}
