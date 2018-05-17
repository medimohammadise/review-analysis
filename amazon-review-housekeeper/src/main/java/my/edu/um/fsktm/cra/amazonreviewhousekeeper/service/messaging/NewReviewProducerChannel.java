package my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface NewReviewProducerChannel {
	 String CHANNEL = "newreview-Channel";

	    @Output(CHANNEL)
	    MessageChannel messageChannel();
}
