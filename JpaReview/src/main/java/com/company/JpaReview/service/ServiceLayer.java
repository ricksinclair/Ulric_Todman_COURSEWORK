package com.company.JpaReview.service;

import com.company.JpaReview.dao.CustomerRepository;
import com.company.JpaReview.dao.InvoiceRepository;
import com.company.JpaReview.model.Customer;
import com.company.JpaReview.model.Invoice;
import com.company.JpaReview.viewModel.CustomerViewModel;
import com.company.JpaReview.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ServiceLayer {
    private CustomerRepository customerRepository;
    private InvoiceRepository invoiceRepository;

    @Autowired
    public ServiceLayer(CustomerRepository cr, InvoiceRepository ir){
        this.customerRepository = cr;
        this.invoiceRepository = ir;
    }


    public InvoiceViewModel addInvoice(InvoiceViewModel ivm){
        Invoice i = new Invoice();
        i.setCustomerId(ivm.getCustomerId());
        i.setOrderDate(ivm.getOrderDate());
        i.setPickupDate(ivm.getPickupDate());
        i.setReturnDate(ivm.getReturnDate());
        i.setLateFee(ivm.getLateFee());
        i = invoiceRepository.save(i);
        ivm.setInvoiceId(i.getInvoiceId());
        return ivm;
    }

    public CustomerViewModel addCustomer(CustomerViewModel cvm) {
        Customer c = new Customer();
        c.setCompany(cvm.getCompany());
        c.setEmail(cvm.getEmail());
        c.setFirstName(cvm.getFirstName());
        c.setLastName(cvm.getLastName());
        c.setPhone(cvm.getPhone());
        c = customerRepository.save(c);

        cvm.setCustomerId(c.getCustomerId());
        return cvm;
    }
}
