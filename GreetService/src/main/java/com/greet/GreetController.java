package com.greet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
    @Autowired
    private  WelcomeFeignClient welcomeFeignClient;
    @GetMapping("/greet")
    public  String greet() {
        String welcomeMessage = welcomeFeignClient.getWelcomeMessage();
        return  "From greet service "+welcomeMessage;

    }
}
