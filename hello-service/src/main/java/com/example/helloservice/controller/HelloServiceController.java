package com.example.helloservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloServiceController {

    @RequestMapping(value = "/hello/{name}")
    @ResponseStatus(code = HttpStatus.OK)

    public String hello(@PathVariable String name){


      return "Hello, "+name;
    }
}
