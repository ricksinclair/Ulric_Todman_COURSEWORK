package com.trilogyed.hellocloudservice.util.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "random-greeting-service")
public interface RandomGreetingClient {

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public String getRandomGreeting();
}
