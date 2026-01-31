package org.example.mvc.controller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService {


    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/greeting") // Maps this method to GET requests at /greeting
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        // The @RequestParam annotation expects a name value in the request
        // If not provided, it defaults to "World"
        return String.format("Hello %s!", name);
    }

}
