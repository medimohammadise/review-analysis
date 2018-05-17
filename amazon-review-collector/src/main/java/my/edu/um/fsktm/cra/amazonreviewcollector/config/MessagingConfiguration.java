package my.edu.um.fsktm.cra.amazonreviewcollector.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

import my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging.ConsumerChannel;



/**
 * Configures Spring Cloud Stream support.
 *
 * See http://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/
 * for more information.
 */
@EnableBinding(value = {Source.class, ConsumerChannel.class})
public class MessagingConfiguration {

}
