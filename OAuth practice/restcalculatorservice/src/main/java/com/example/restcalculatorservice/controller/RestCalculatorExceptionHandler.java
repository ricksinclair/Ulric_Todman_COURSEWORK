package com.example.restcalculatorservice.controller;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.validation.UnexpectedTypeException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.err+json")

public class RestCalculatorExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)

    public ResponseEntity<VndErrors> restCalculatorValidationError(MethodArgumentNotValidException e, WebRequest request) {
        // BindingResult holds the validation errors
        BindingResult result = e.getBindingResult();
        // Validation errors are stored in FieldError objects
        List<FieldError> fieldErrors = result.getFieldErrors();

        // Translate the FieldErrors to VndErrors
        List<VndErrors.VndError> vndErrorList = new ArrayList<>();

        for (FieldError fieldError : fieldErrors) {
            VndErrors.VndError vndError = new
                    VndErrors.VndError(request.toString(), fieldError.getDefaultMessage());
            vndErrorList.add(vndError);
        }

        // Wrap all of the VndError objects in a VndErrors object
        VndErrors vndErrors = new VndErrors(vndErrorList);

        // Create and return the ResponseEntity
        ResponseEntity<VndErrors> responseEntity = new
                ResponseEntity<>(vndErrors, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)

    public ResponseEntity<VndErrors> restCalculatorBadRequest(HttpMessageNotReadableException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        return  responseEntity;
    }


    @ExceptionHandler(value = {UnexpectedTypeException  .class})
    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> restCalculatorIncompleteRequest(UnexpectedTypeException e, WebRequest request) {
        VndErrors error = new VndErrors(request.toString(), "You have not provided both operands");
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
        return  responseEntity;
    }
}
