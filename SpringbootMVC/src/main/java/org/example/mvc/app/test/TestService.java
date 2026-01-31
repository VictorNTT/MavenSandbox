package org.example.mvc.app.test;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
    @GetMapping("/test")
    public String index() {
        return "From test service!";
    }
}
