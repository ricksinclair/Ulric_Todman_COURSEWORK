package com.company.UlricTodmanU1Capstone.controller;


import com.company.UlricTodmanU1Capstone.exception.NotFoundException;
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

    @RequestMapping(path = "/Console/Manufacturer/{manufacturer}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getConsolesByManufacturer(@PathVariable String manufacturer) {
        return serviceLayer.getConsolesByManufacturer(manufacturer);
    }

    @RequestMapping(path = "/Console", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Console> getAllConsoles() {
        return serviceLayer.getAllConsoles();
    }

    @RequestMapping(path = "/Console", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Console addConsole(@RequestBody @Valid Console console) {
        return serviceLayer.addConsole(console);
    }

    @RequestMapping(path = "/Console", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateConsole(@RequestBody @Valid Console console) {
        serviceLayer.updateConsole(console);
    }

    @RequestMapping(path = "/Console/{consoleId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Console getConsoleById(@PathVariable int consoleId) {
        Console console = serviceLayer.getConsole(consoleId);

        if (console == null)
            throw new NotFoundException("T shirt could not be retrieved for id " + consoleId);
        return console;
    }

    @RequestMapping(path = "/Console/{consoleId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable int consoleId) {
        Console console = serviceLayer.getConsole(consoleId);

        if (console == null)
            throw new NotFoundException("T shirt could not be retrieved for id " + consoleId);
        serviceLayer.deleteConsole(consoleId);
    }

}
