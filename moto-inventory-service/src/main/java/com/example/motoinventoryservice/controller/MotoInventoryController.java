package com.example.motoinventoryservice.controller;


import com.example.motoinventoryservice.model.Motorcycle;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Random;

@RestController
public class MotoInventoryController {
    @RequestMapping(value = "/motorcycles", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK )
    public Motorcycle createMotorcycle(@RequestBody @Valid Motorcycle motor){//if it has fields that map. it will all link up.
        Random rnd = new Random();
        int tempId = rnd.nextInt(9999);
        motor.setId(tempId);
        System.out.println(motor.toString());
        return motor;
    }

    @RequestMapping(value="/motorcycles/{motoId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteMotorcycle(@PathVariable int motoId){



    }
}
