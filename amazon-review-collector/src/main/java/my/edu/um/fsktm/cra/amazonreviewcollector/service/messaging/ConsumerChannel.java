package my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface ConsumerChannel {
	String CHANNEL = "newreview-subChannel";
	 @Input(CHANNEL)
	 SubscribableChannel subscribableChannel();

}
