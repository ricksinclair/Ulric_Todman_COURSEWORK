package com.company.JpaReview.controller;

import com.company.JpaReview.model.Customer;
import com.company.JpaReview.service.ServiceLayer;
import com.company.JpaReview.viewModel.CustomerViewModel;
import com.company.JpaReview.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private ServiceLayer service;

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public CustomerViewModel addCustomer(@RequestBody CustomerViewModel cvm){

       return service.addCustomer(cvm);

    }

    @RequestMapping(value = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody InvoiceViewModel ivm){

       return service.addInvoice(ivm);

    }
}
