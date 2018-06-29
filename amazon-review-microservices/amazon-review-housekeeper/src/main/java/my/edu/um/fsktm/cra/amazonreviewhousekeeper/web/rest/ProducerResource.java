package my.edu.um.fsktm.cra.amazonreviewhousekeeper.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import org.springframework.messaging.Message;
import my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging.NewReviewPublisherChannel;
import my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging.NewReviewPublishedEvent;
@RestController
@RequestMapping("/api")

public class ProducerResource {
	private MessageChannel channel;
	private final Logger log = LoggerFactory.getLogger(getClass());
    public ProducerResource(NewReviewPublisherChannel  channel) {
        this.channel = channel.messageChannel();
    }

    @GetMapping("/review/{productId}")
    @Timed
    public void produce(@PathVariable String productId) {
    		  NewReviewPublishedEvent newReviewPublishedEvent=new NewReviewPublishedEvent(productId);
          Message<NewReviewPublishedEvent> message= MessageBuilder.withPayload(newReviewPublishedEvent)
          		//.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
        		  .setHeader(KafkaHeaders.MESSAGE_KEY, newReviewPublishedEvent.getProductId().getBytes())
          		.build();
          try {
    	      		channel.send(message);
    	      		log.info("message sent "+message);
          }
          catch(Exception ex	) {
        	  		log.error(ex.getMessage());
          }
       
    }
}
