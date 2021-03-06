package com.company.ulrictodmanrandomquoteservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;



@RestController

public class RandomQuoteServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${eightBallServiceName}")
    private String eightBallServiceName;

    @Value("${serviceProtocol}")
    private String serviceProtocol;

    @Value("${servicePath}")
    private String servicePath;


    private String[] quotesList= new String[]{
            "To me programming is more than an important practical art. It is also a gigantic undertaking in the foundations of knowledge. - Grace Hopper",
            "Programs must be written for people to read, and only incidentally for machines to execute. - Hal Ableson",
            "Don't call me the mother of the internet. - Radia Perlman",
            "When I first started using the phrase software engineering, it was considered to be quite amusing. They used to kid me about my radical ideas. Software eventually and necessarily gained the same respect as any other discipline. - Margaret Hamilton",
            "Machines take me by surprise with great frequency. - Alan Turing",
            "The function of good software is to make the complex appear simple. - Grady Booch",
            "An API that isn't comprehensible isn't usable. - James Gosling",
            "I'm not a great programmer; I'm just a good programmer with great habits. - Martin Fowler"
    };

    private List quoteArrayList = Arrays.asList(quotesList);
    @RequestMapping(path = "/quote", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String getRandomQuote(){
        Random random = new Random();
        return (String) quoteArrayList.get(random.nextInt(quoteArrayList.size()));
    }

    @RequestMapping(path = "/answerme", method = RequestMethod.GET)
    public String getAnswer(){
    List<ServiceInstance> instances = discoveryClient.getInstances(eightBallServiceName);
        System.out.println(instances);

        String eightBallServiceUri = serviceProtocol+instances.get(0).getHost()+":"+instances.get(0).getPort()+servicePath;
        return restTemplate.getForObject(eightBallServiceUri, String.class);

    }

}
