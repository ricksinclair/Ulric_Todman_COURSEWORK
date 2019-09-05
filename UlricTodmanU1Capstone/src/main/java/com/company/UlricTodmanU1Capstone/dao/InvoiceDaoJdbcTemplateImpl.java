package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {
    @Override
    public Invoice addInvoice(Invoice invoice) {
        return null;
    }

    @Override
    public Invoice getInvoice(int invoiceId) {
        return null;
    }

    @Override
    public void deleteInvoice(int invoiceId) {
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return null;
    }


}
