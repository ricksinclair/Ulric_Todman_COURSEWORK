    package com.example.echorangeservice.controller;

    import org.springframework.http.HttpStatus;
    import org.springframework.web.bind.annotation.*;

    @RestController
    public class EchoRangeServiceController {

        @RequestMapping(value = "/echo/{input}", method = RequestMethod.GET)
        @ResponseStatus(code = HttpStatus.OK)
        public int echo(@PathVariable int input){


            if(input < 1 || input > 10){
                throw new IllegalArgumentException("Input must be between 1 and 10.");
            }
                return input;



        }


    }
