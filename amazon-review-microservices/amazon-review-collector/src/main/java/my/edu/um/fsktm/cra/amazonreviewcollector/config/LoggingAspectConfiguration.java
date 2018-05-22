package my.edu.um.fsktm.cra.amazonreviewcollector.config;

import io.github.jhipster.config.JHipsterConstants;
import my.edu.um.fsktm.cra.amazonreviewcollector.logging.LoggingAspect;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy
public class LoggingAspectConfiguration {

    @Bean
    @Profile(JHipsterConstants.SPRING_PROFILE_DEVELOPMENT)
    public LoggingAspect loggingAspect(Environment env) {
        return new LoggingAspect(env);
    }
}
