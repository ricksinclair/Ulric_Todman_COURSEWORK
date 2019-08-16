package com.example.monthconverterservice.controller;

import com.sun.nio.sctp.IllegalReceiveException;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonthConverterServiceController {

    @RequestMapping(value = "/month/{monthNumber}", method = RequestMethod.GET)
    @ResponseStatus(code= HttpStatus.OK)

    public String monthConverter(@PathVariable int monthNumber){
        String month ="";
        if(monthNumber<1||monthNumber>12){
            throw new IllegalArgumentException("Month must be a whole number between 1 and 12");

        }
        switch(monthNumber){
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month ="September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }


        return month;


    }
}
