package my.edu.um.fsktm.cra.amazonreviewcollector.config;

import java.text.SimpleDateFormat;
import java.util.Date;

import my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging.ProducerChannel;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.GenericMessage;

import my.edu.um.fsktm.cra.amazonreviewcollector.service.messaging.ConsumerChannel;

/**
 * Configures Spring Cloud Stream support.
 *
 * This works out-of-the-box if you use the Docker Compose configuration at "src/main/docker/kafka.yml".
 *
 * See http://docs.spring.io/spring-cloud-stream/docs/current/reference/htmlsingle/
 * for the official Spring Cloud Stream documentation.
 */
@EnableBinding(value = { Source.class,ConsumerChannel.class,ProducerChannel.class})
public class MessagingConfiguration {
	 private final Logger log = LoggerFactory.getLogger(getClass());
    /**
     * This sends a test message at regular intervals.
     *
     * In order to see the test messages, you can use the Kafka command-line client:
     * "./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-jhipster --from-beginning".
     */
    @Bean
    @InboundChannelAdapter(value = Source.OUTPUT)
    public MessageSource<String> timerMessageSource() {
        return () -> new GenericMessage<>("Test message from JHipster sent at " +
            new SimpleDateFormat().format(new Date()));
    }
}
