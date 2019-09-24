package com.trilogyed.securersvp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RsvpController {

    @RequestMapping(value= "/publicEvent", method = RequestMethod.GET)
    public String viewPublicEvents(){
        return "Here are the public events for your joy.";
    }

    @RequestMapping(value = "/privateEvent", method = RequestMethod.GET)
    public String viewPrivateEvents(){
        return "Here are the PRIVATE events for your consideration.";
    }
}
