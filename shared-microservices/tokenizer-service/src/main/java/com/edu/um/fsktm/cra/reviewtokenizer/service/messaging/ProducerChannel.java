package com.edu.um.fsktm.cra.reviewtokenizer.service.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

//import org.springframework.messaging.SubscribableChannel;

public interface ProducerChannel {
	String NEW_REVIEW_COLECTED_CHANNEL = "newreview-grabChannel";
	@Output(NEW_REVIEW_COLECTED_CHANNEL)
	 //KStream<String,NewReviewPublishedEvent> subChannel();
    MessageChannel messageChannel();

}
