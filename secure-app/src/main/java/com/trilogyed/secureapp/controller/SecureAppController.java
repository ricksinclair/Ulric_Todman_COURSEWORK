package com.trilogyed.secureapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SecureAppController {

    @RequestMapping(value = "/open", method = RequestMethod.GET)
    public String open() {
        return "Open endpoint - anyone can access.";
    }

    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedIn(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you're logged in!";
    }

    @RequestMapping(value = "/needsRole", method = RequestMethod.GET)
    public String authRoleGet(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you have the MGR role";
    }

    @RequestMapping(value = "/needsRole", method = RequestMethod.POST)
    public String authRolePost(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you have the ADMIN role";
    }

    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
    public String allDone() {
        return "That's All Folks!";
    }
}
