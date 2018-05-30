package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
//import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannel {
	String CHANNEL = "newreview-subChannel";
	 @Input(CHANNEL)
	 //KStream<String,NewReviewPublishedEvent> subChannel();
	 SubscribableChannel subscribableChannel();

}
