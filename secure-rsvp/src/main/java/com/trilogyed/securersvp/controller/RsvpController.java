package com.trilogyed.securersvp.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.io.PrintWriter;
import java.security.Principal;

@RestController
public class RsvpController {

    @RequestMapping(value= "/publicEvent", method = RequestMethod.GET)
    public String viewPublicEvents(){
        return "Here are the public events for your joy.";
    }

    @RequestMapping(value = "/privateEvent", method = RequestMethod.GET)
    public String viewPrivateEvents(Principal principal){
        return "Here are the PRIVATE events for your consideration: "+        principal.getName();
    }

    @RequestMapping(value = "/registerPublicEvent",method = RequestMethod.GET)
    public String registerPublicEvent(){
        return "your public event";
    }

    @RequestMapping(value = "/registerPrivateEvent",method = RequestMethod.GET)
    public String registerPrivateEvent(Principal principal){
        return "Welcome to your private event "+ principal.getName();
    }

    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
    public   String allDone(){
        return "ALL DONE! YOU'VE BEEN LOGGED OUT!";
    }

    @RequestMapping(value = "/publishEvent", method = RequestMethod.GET)
    public String publishEvent(Principal principal){
        return "event published "+principal.getName();
    }

    @RequestMapping(value = "/privateEvent/{id}", method = RequestMethod.DELETE)
    public String deletePrivateEvent(Principal principal, @PathVariable int id){
        return principal.getName()+", you have deleted the private event";
    }
}
