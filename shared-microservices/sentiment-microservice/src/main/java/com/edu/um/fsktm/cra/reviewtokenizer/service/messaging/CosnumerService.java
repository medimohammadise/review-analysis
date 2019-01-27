package com.edu.um.fsktm.cra.reviewtokenizer.service.messaging;


import com.edu.um.fsktm.cra.reviewtokenizer.service.SentimentService;
import com.edu.um.fsktm.cra.reviewtokenizer.web.rest.dto.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CosnumerService {
     private final SentimentService sentimentService;

	 private final Logger log = LoggerFactory.getLogger(getClass());
	 	public CosnumerService(SentimentService sentimentService
				//, MessageChannel channel
		)
		{
	 		this.sentimentService=sentimentService;
	 		//this.channel=channel;
	 	}

	 	@StreamListener(ConsumerChannel.NEW_REVIEW_CHANNEL)
	    public void consume(Review review) {
	        log.info("Received message in sentiment microservice: {}.", review.getId());
	        double sentiment=sentimentService.sentiment(review.getReviewText());
	        review.setSentiment(sentiment);


	    }



	   /*@StreamListener(ConsumerChannel.CHANNEL)
	    public void consume(@Input(ConsumerChannel.CHANNEL) KStream<String,ReviewEvent> newReviewPublishedEvent ) {
	    		//newReviewPublishedEvent.flatMap(arg0)
	    	    log.info("successfully created connected to steam of new reviews");



           newReviewPublishedEvent.map((k, v) ->  {
               log.info("Key: " + k + " value: " + v.getEventDateTime());
               return new KeyValue<>(k, v);
           });

	        //reviewService.saveReview(readyToCollectReview.getProductId());
	    }*/
}
