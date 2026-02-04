package org.example.mvc.app;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.ConfigurationPropertiesSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ConfigManager {

    @Bean
    @ConfigurationProperties (prefix = "app")
    public Map<String, String> appConfig () {
        System.out.println("appConfigs() runs");
        // Test if resource is loaded into classpath
        System.out.println("resource loaded --> " + this.getClass().getResource("/application.properties"));
        return new HashMap<String, String>();
    }

    @Bean
    @ConfigurationProperties (prefix = "mail")
    public Map<String, String> mailConfig () {
        System.out.println("mailConfig() runs");
        // Test if resource is loaded into classpath
        System.out.println("resource loaded --> " + this.getClass().getResource("/application.properties"));
        return new HashMap<String, String>();
    }

    @Bean
    @ConfigurationProperties (prefix = "item")
    public Item item () {
        System.out.println("item() runs");
        // Test if resource is loaded into classpath
        System.out.println("resource loaded --> " + this.getClass().getResource("/application.properties"));
        return new Item();
    }

    @Bean
    @ConfigurationProperties // No prefix means all configs will be loaded including system configs.... the entire universe
    public Map<String, String> allConfigs () {
        System.out.println("allConfigs() runs");
        // Test if resource is loaded into classpath
        System.out.println("resource loaded --> " + this.getClass().getResource("/application.properties"));
        return new HashMap<String, String>();
    }
}
