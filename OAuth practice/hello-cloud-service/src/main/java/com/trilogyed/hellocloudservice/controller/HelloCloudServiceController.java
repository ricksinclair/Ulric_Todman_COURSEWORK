package com.trilogyed.hellocloudservice.controller;

import com.trilogyed.hellocloudservice.util.feign.RandomGreetingClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RefreshScope
public class HelloCloudServiceController {
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    private RestTemplate restTemplate = new RestTemplate();
//
//    @Value("${randomGreetingServiceName}")
//    private String randomGreetingServiceName;
//
//    @Value("${serviceProtocol}")
//    private String serviceProtocol;
//
//    @Value("${servicePath}")
//    private String servicePath;
//
//
//    @Value("${officialGreeting}")//allows you to grab item from config file(in git repo)     and assign to variable
//    private String officialGreeting;

    @Autowired
    private final RandomGreetingClient client;

    HelloCloudServiceController(RandomGreetingClient client){
        this.client=client;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloCloud() {

//        List<ServiceInstance> instances = discoveryClient.getInstances(randomGreetingServiceName);
//
//        String randomGreetingServiceUri = serviceProtocol + instances.get(0).getHost()+ ":"+ instances.get(0).getPort()+ servicePath;
//        String greeting = restTemplate.getForObject(randomGreetingServiceUri, String.class);
//        return greeting;

        return client.getRandomGreeting();

    }

}


