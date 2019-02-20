package com.edu.um.fsktm.cra.reviewtokenizer.service;

import com.edu.um.fsktm.cra.reviewtokenizer.service.messaging.ReviewAnalyseResultPublisherChannel;
import com.edu.um.fsktm.cra.reviewtokenizer.service.messaging.ReviewEvent;
import com.edu.um.fsktm.cra.reviewtokenizer.web.rest.dto.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SentimentMessagePublisherService {

    private final MessageChannel channel;
    private final Logger log = LoggerFactory.getLogger(getClass());
    public SentimentMessagePublisherService(ReviewAnalyseResultPublisherChannel channel){
        this.channel=channel.messageChannel();

    }
    public void sendMessage(Review review){
			ReviewEvent reviewEvent = new ReviewEvent(LocalDate.now(),review.getId(),review.getSentiment(),review.getPosTags());
			Message<ReviewEvent> message = MessageBuilder.withPayload(reviewEvent)
					//.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
					.setHeader(KafkaHeaders.MESSAGE_KEY, reviewEvent.getReviewId().getBytes())
					.build();
			try {
				channel.send(message);
				log.info("message sent " + message);
			} catch (Exception ex) {
				log.error(ex.getMessage());
			}

		}
}
