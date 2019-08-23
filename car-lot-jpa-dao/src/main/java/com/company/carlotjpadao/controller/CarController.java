package com.company.carlotjpadao.controller;


import com.company.carlotjpadao.dao.CarRepository;
import com.company.carlotjpadao.dto.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
   @Autowired
    CarRepository carRepo;

    @RequestMapping(value = "/car", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public List<Car> getAllCars(){
        return carRepo.findAll();

    }

    @RequestMapping(value = "/car/make/{make}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public List<Car> getCarByMake(@PathVariable String make){
        return carRepo.findByMake(make);

    }

    @RequestMapping(value = "/car/color/{color}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public List<Car> getCarByColor(@PathVariable String color){
        return carRepo.findByColor(color);

    }

    @RequestMapping(value = "/car/make/{make}/color/{color}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public List<Car> getCarByMake(@PathVariable String make, @PathVariable String color){
        return carRepo.findByMakeAndColor(make, color);

    }
}
