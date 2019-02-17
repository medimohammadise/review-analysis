package my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface NewReviewPublisherChannel {
	 String CHANNEL = "newreview-Channel";

	    @Output(CHANNEL)
	    MessageChannel messageChannel();
}
