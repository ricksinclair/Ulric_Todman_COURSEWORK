package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.Invoice;

public interface InvoiceDao {

    Invoice addInvoice(Invoice invoice);
    Invoice getInvoice(int invoiceId);
}
