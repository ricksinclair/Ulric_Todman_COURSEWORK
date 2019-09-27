package com.example.motoinventoryservice.controller;

import com.example.motoinventoryservice.dao.MotoInventoryDao;
import com.example.motoinventoryservice.model.Motorcycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Random;

@RestController
public class MotoInventoryController {

    @Autowired
    private MotoInventoryDao dao;


    @RequestMapping(value = "/motorcycles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Motorcycle createMotorcycle(@RequestBody @Valid Motorcycle motorcycle) {
        return dao.addMotorcycle(motorcycle);
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Motorcycle getMotorcycle(@PathVariable int motoId) {
        return dao.getMotorcycle(motoId);
    }

    @RequestMapping(value = "/motorcycles/{motoId}", method = RequestMethod.DELETE)
    @ResponseStatus( value = HttpStatus.NO_CONTENT)
    public void deleteMotorcycle(@PathVariable("motoId") int motoId) {
        dao.deleteMotorcycle(motoId);
    }

    @RequestMapping(value = "/motorcycles", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void updateMotorcycle(@RequestBody @Valid Motorcycle motorcycle) {
        dao.updateMotorcycle(motorcycle);

    }

    @RequestMapping(value = "/loggedin", method = RequestMethod.GET)
    public String loggedIn(Principal principal) {
        return "Hello " + principal.getName() + "! Looks like you're logged in!";
    }

    @RequestMapping(value = "/allDone", method = RequestMethod.GET)
    public String allDone() {
        return "That's All Folks!";
    }
}
