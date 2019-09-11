package com.trilogyed.hellocloudservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class HelloCloudServiceController {

    @Value("${officialGreeting}")//allows you to grab item from config file(in git repo)     and assign to variable
    private String officialGreeting;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloCloud(){
        return officialGreeting;
    }
}


