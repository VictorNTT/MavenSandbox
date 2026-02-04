package org.example.mvc.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

//Scan for services in the packages below. By default, it only scan from the current
// package where this app resign.
@ComponentScan(basePackages = "org.example.mvc.app.test")
@ComponentScan(basePackages = "org.example.mvc.controller")
@ComponentScan(basePackages = "org.example.mvc.app")

@SpringBootApplication
public class SpringbootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootApp.class, args);
    }

    //@Bean // run on start up
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }

        };
    }

}
