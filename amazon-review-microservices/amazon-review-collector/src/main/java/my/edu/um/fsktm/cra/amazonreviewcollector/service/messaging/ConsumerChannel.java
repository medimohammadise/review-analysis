package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannel {
	String NEW_REVIEW_CHANNEL = "newreview-subChannel";
	 @Input(NEW_REVIEW_CHANNEL)
	 //KStream<String,NewReviewPublishedEvent> subChannel();
	 SubscribableChannel subscribableChannel();

}
