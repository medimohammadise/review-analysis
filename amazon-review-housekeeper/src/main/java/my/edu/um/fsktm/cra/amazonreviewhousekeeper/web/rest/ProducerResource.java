package my.edu.um.fsktm.cra.amazonreviewhousekeeper.web.rest;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;

import my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging.NewReviewProducerChannel;
import my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging.ReadyToCollectReview;
@RestController
@RequestMapping("/api")
public class ProducerResource {
	private MessageChannel channel;

    public ProducerResource(NewReviewProducerChannel  channel) {
        this.channel = channel.messageChannel();
    }

    @GetMapping("/review/{count}")
    @Timed
    public void produce(@PathVariable String count) {
       
            channel.send(MessageBuilder.withPayload(new ReadyToCollectReview().setProductId(count))
            		.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
            		.build());
       
    }
}
