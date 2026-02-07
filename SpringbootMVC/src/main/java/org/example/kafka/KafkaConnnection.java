package org.example.kafka;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConnnection {
    @Bean
    @ConfigurationProperties(prefix ="app.kafka.connect.server")
    public Map<String, String> properties() {
        return new HashMap<>();
    }
}
