package com.example.restcalculatorservice.controller;


import com.example.restcalculatorservice.model.Operands;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class RestCalculatorServiceController {

@RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Integer add(@RequestBody @Valid Operands operands){
    return operands.getOperand1()+operands.getOperand2();
}
@RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Integer subtract(@RequestBody @Valid Operands operands){
    return operands.getOperand1()-operands.getOperand2();
}
@RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public Integer multiply(@RequestBody @Valid Operands operands){
    return operands.getOperand1()*operands.getOperand2();
}
@RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public double divide(@RequestBody @Valid Operands operands){
    return (double)operands.getOperand1()/(double)operands.getOperand2()    ;
}

}
