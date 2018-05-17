package my.edu.um.fsktm.cra.amazonreviewhousekeeper.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

import my.edu.um.fsktm.cra.amazonreviewhousekeeper.service.messaging.NewReviewProducerChannel;

/**
 * Configures Spring Cloud Stream support.
 *
 * See http://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/
 * for more information.
 */
@EnableBinding(value = {Source.class,NewReviewProducerChannel.class})
public class MessagingConfiguration {

}
