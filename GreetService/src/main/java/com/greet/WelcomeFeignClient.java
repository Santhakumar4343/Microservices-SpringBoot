package com.greet;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name ="WELCOMESERVICE")
public interface WelcomeFeignClient {
    @GetMapping("/welcome")
    String getWelcomeMessage();
}
