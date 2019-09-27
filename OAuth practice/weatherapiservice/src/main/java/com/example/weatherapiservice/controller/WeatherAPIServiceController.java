package com.example.weatherapiservice.controller;


import com.example.weatherapiservice.model.Conditions;
import com.example.weatherapiservice.model.Temperature;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class WeatherAPIServiceController {

    @RequestMapping(value = "/temp/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Temperature getTemperature(@PathVariable  String zipcode) {

        if( !zipcode.matches("\\d{5}+")||zipcode.length()!=5){
            throw new IllegalArgumentException("Incorrect Zip Format");
        }
        return new Temperature();
    }

    @RequestMapping(value = "/conditions/{zipcode}", method = RequestMethod.GET)
    @ResponseStatus(value= HttpStatus.OK)
    public Conditions getConditions(@PathVariable  String zipcode){
        if( !zipcode.matches("\\d{5}+")||zipcode.length()!=5){
            throw new IllegalArgumentException("Incorrect Zip Format");
        }
        return new Conditions();
    }
}
