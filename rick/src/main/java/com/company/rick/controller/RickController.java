package com.company.rick.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RickController {


    @RequestMapping(path = "/hello", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(value = HttpStatus.OK)
    public String helloWorld(){

        return  "Hello World!";
    }
}
