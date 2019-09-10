package com.company.UlricTodmanU1Capstone.controller;


import com.company.UlricTodmanU1Capstone.dao.*;
import com.company.UlricTodmanU1Capstone.model.Console;
import com.company.UlricTodmanU1Capstone.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ConsoleController {


    @Autowired
    ServiceLayer serviceLayer;

    @RequestMapping(path = "/console/manufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer){
        return serviceLayer.getConsolesByManufacturer(manufacturer);
    }

    @RequestMapping(path = "/console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles(){
        return serviceLayer.getAllConsoles();
    }

    @RequestMapping(path = "/console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console addConsole(@RequestBody @Valid Console console){
        return serviceLayer.addConsole(console);
    }

    @RequestMapping(path = "/console", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateConsole(@RequestBody @Valid Console console){
         serviceLayer.updateConsole(console);
    }

    @RequestMapping(path = "/console/{consoleId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsoleById(@PathVariable int consoleId){
        return serviceLayer.getConsole(consoleId);
    }

    @RequestMapping(path = "/console/{consoleId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int consoleId){
        serviceLayer.deleteConsole(consoleId);
    }

}
