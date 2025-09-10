package com.welcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @Autowired
    private Environment environment;
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Welcome Service!" + environment.getProperty("server.port");
    }
}
