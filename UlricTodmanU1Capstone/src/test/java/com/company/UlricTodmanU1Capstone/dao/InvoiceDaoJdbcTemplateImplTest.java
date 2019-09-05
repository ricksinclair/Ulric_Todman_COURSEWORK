package com.company.UlricTodmanU1Capstone.dao;


import com.company.UlricTodmanU1Capstone.model.Console;
import com.company.UlricTodmanU1Capstone.model.Game;
import com.company.UlricTodmanU1Capstone.model.Invoice;
import com.company.UlricTodmanU1Capstone.model.TShirt;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class InvoiceDaoJdbcTemplateImplTest {

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    ConsoleDao consoleDao;



    @Before
    public void setUp(){
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.forEach(invoice->{
            invoiceDao.deleteInvoice(invoice.getInvoiceId());
        });

        List<Console> consoleList = consoleDao.getAllConsoles();
        consoleList.forEach(console -> {
            consoleDao.deleteConsole(console.getConsoleId());
        });


    }

    @Test
    public void addGetDeleteInvoice(){
        Console console = new Console();
        console.setManufacturer("Sony");
        console.setModel("PS4 Pro");
        console.setMemoryAmount("8GB");
        console.setProcessor("AMD");
        console.setQuantity(20);
        console.setPrice(new BigDecimal("299.99"));
        console = consoleDao.addConsole(console);

        Invoice invoice = new Invoice();
        invoice.setName("John Doe");
        invoice.setStreet("1155 Broadway");
        invoice.setCity("New York");
        invoice.setState("NY");
        invoice.setZipCode("10013");
        invoice.setItemType("Consoles");
        invoice.setItemId(console.getConsoleId());
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setQuantity(1);
        invoice.setSubTotal(new BigDecimal("299.99"));
        invoice.setTax(new BigDecimal(".06"));
        invoice.setProcessingFee( new BigDecimal("14.99"));
        invoice.setTotal( new BigDecimal("332.97"));

        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice, invoice2);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());

        invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertNull(invoice2);
    }


    @Test
    public void getAllInvoices(){
        Console console = new Console();
        console.setManufacturer("Sony");
        console.setModel("PS4 Pro");
        console.setMemoryAmount("8GB");
        console.setProcessor("AMD");
        console.setQuantity(20);
        console.setPrice(new BigDecimal("299.99"));
        console = consoleDao.addConsole(console);

        Invoice invoice = new Invoice();
        invoice.setName("John Doe");
        invoice.setStreet("1155 Broadway");
        invoice.setCity("New York");
        invoice.setState("NY");
        invoice.setZipCode("10013");
        invoice.setItemType("Consoles");
        invoice.setItemId(console.getConsoleId());
        invoice.setQuantity(1);
        invoice.setUnitPrice(new BigDecimal("299.99"));
        invoice.setSubTotal(new BigDecimal("299.99"));
        invoice.setTax(new BigDecimal(".06"));
        invoice.setProcessingFee( new BigDecimal("14.99"));
        invoice.setTotal( new BigDecimal("332.97"));
        invoiceDao.addInvoice(invoice);
        invoice.setName("Jane Doe");
        invoice.setStreet("624 Park Ave");
        invoiceDao.addInvoice(invoice);
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        assertEquals(invoiceList.size(), 2);

    }


}
