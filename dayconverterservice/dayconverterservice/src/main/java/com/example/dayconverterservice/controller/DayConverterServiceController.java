package com.example.dayconverterservice.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayConverterServiceController {

    @RequestMapping(value = "/day/{dayNumber}", method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)

    public String convertDay(@PathVariable int dayNumber){
        String rtn="";
        if(dayNumber<1||dayNumber>7){
            throw new IllegalArgumentException("Input must be a value between 1 and 7");
        }
        switch(dayNumber){
            case 1:
                rtn =  "Sunday";
                break;
            case 2:
                rtn =  "Monday";
                break;

            case 3:
                rtn =  "Tuesday";
                break;
            case 4:
                rtn =  "Wednesday";
                break;
            case 5:
                rtn =  "Thursday";
                break;
            case 6:
                rtn =  "Friday";
                break;
            case 7:
                rtn =  "Saturday";
                break;
        }
        return rtn;
    }

}
