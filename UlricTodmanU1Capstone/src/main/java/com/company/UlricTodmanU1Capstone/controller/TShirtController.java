package com.company.UlricTodmanU1Capstone.controller;


import com.company.UlricTodmanU1Capstone.model.TShirt;
import com.company.UlricTodmanU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TShirtController {

    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(path= "/TShirt", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getAllTShirts(){
        return serviceLayer.getAllTShirts();
    }
    @RequestMapping(path= "/TShirt/{color}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getShirtsByColor(@PathVariable String color){
        return serviceLayer.getTShirtsByColor(color);
    }
    @RequestMapping(path= "/TShirt/{size}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<TShirt> getShirtsBySize(@PathVariable String size){
        return serviceLayer.getTShirtsBySize(size);
    }

    @RequestMapping(path= "/TShirt", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public TShirt addTShirt(@RequestBody @Valid TShirt tShirt){
        return serviceLayer.addTShirt(tShirt);
    }

    @RequestMapping(path= "/TShirt", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateTShirt(@RequestBody @Valid TShirt tShirt){
         serviceLayer.updateTShirt(tShirt);
    }

    @RequestMapping(path = "/TShirt/{tShirtId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public TShirt getTShirtById(@PathVariable int tShirtId){
        return serviceLayer.getTShirt(tShirtId);
    }


    @RequestMapping(path = "/TShirt/{tShirtId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteTShirt(@PathVariable int tShirtId){
         serviceLayer.deleteTShirt(tShirtId);
    }

}
