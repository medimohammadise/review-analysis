package my.edu.um.fsktm.cra.amazonreviewhousekeeper.config;

import io.github.jhipster.config.JHipsterConstants;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.*;

@Configuration
@Profile(JHipsterConstants.SPRING_PROFILE_CLOUD)
public class CloudDatabaseConfiguration extends AbstractCloudConfig {
}