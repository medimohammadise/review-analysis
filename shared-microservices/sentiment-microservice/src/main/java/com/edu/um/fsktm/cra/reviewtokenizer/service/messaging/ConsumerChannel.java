package com.edu.um.fsktm.cra.reviewtokenizer.service.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

//import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannel {
	String NEW_REVIEW_CHANNEL = "newreview-grabChannel";
	 @Input(NEW_REVIEW_CHANNEL)
	 //KStream<String,ReviewEvent> subChannel();
     SubscribableChannel subscribableChannel();

}
