package com.edu.um.fsktm.cra.reviewtokenizer.service.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

//import org.springframework.messaging.SubscribableChannel;

public interface ReviewAnalyseResultPublisherChannel {
	String REVIEW_ANALYSED_CHANNEL = "review-analyse-result";
	@Output(REVIEW_ANALYSED_CHANNEL)
	 //KStream<String,ReviewEvent> subChannel();
    MessageChannel messageChannel();

}
