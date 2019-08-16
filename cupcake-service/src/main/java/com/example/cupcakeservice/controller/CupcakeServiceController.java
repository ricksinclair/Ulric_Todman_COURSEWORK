package com.example.cupcakeservice.controller;

import com.example.cupcakeservice.model.Cupcake;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class CupcakeServiceController {

    @RequestMapping(value = "/cupcakes", method = RequestMethod.POST)

    public Cupcake createCupcake(@RequestBody Cupcake cupcake) {

        Random rnd = new Random();
        int tempId = rnd.nextInt(9999);
        cupcake.setId(tempId);
        System.out.println(cupcake.toString());
        return cupcake;
    }

}


