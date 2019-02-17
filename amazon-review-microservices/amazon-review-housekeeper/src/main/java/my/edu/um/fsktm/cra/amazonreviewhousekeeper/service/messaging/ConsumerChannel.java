package my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

//import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannel {
	String CHANNEL = "newreview-grabChannel";
	 @Input(CHANNEL)
	 //KStream<String,NewReviewPublishedEvent> subChannel();
	 SubscribableChannel subscribableChannel();

}
