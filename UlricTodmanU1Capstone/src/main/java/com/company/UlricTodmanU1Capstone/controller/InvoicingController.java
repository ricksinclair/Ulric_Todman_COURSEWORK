package com.company.UlricTodmanU1Capstone.controller;


import com.company.UlricTodmanU1Capstone.model.Invoice;
import com.company.UlricTodmanU1Capstone.service.ServiceLayer;
import com.company.UlricTodmanU1Capstone.viewmodel.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class InvoicingController {

    @Autowired
    ServiceLayer serviceLayer;


    @RequestMapping(path = "/Invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Invoice processSale(@RequestBody @Valid CustomerOrder customerOrder) {
        return serviceLayer.processInvoiceReq(customerOrder);
    }

    @RequestMapping(path = "/Invoice/{invoiceId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Invoice getInvoice(@PathVariable int invoiceId) {
        return serviceLayer.getInvoice(invoiceId);
    }

}
