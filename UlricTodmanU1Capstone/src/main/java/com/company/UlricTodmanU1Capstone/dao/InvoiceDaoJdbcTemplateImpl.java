package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {

    //Prepared Statements
    private final String INSERT_INVOICE_SQL =
            "INSERT INTO invoice (name, street, city, state, zipcode, item_type, item_id, unit_price, quantity, processing_fee, tax, subtotal, total) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String  GET_INVOICE_SQL =
            "SELECT * FROM invoice WHERE invoice_id = ?";

    private final String DELETE_INVOICE_SQL =
            "DELETE FROM invoice WHERE invoice_id = ?";

    private final String GET_ALL_INVOICES_SQL =
            "SELECT * FROM invoice";


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate) {
        this.jdbcTemplate = newJdbcTemplate;
    }

    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException{
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setQuantity(rs.getInt("quantity"));
        invoice.setName(rs.getString("name"));
        invoice.setCity(rs.getString("city"));
        invoice.setStreet(rs.getString("street"));
        invoice.setState(rs.getString("state"));
        invoice.setZipCode(rs.getString("zipcode"));
        invoice.setItemType(rs.getString("item_type"));
        invoice.setItemId(rs.getInt("item_id"));
        invoice.setUnitPrice(rs.getBigDecimal("unit_price"));
        invoice.setProcessingFee(rs.getBigDecimal("processing_fee"));
        invoice.setTax(rs.getBigDecimal("tax"));
        invoice.setSubTotal(rs.getBigDecimal("subtotal"));
        invoice.setTotal(rs.getBigDecimal("total"));
        return invoice;

    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {

        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getName(),
                invoice.getStreet(),
                invoice.getCity(),
                invoice.getState(),
                invoice.getZipCode(),
                invoice.getItemType(),
                invoice.getItemId(),
                invoice.getUnitPrice(),
                invoice.getQuantity(),
                invoice.getProcessingFee(),
                invoice.getTax(),
                invoice.getSubTotal(),
                invoice.getTotal()
                );

        int id = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        invoice.setInvoiceId(id);
        return invoice;
    }

    @Override
    public Invoice getInvoice(int invoiceId) {


        try{
        return jdbcTemplate.queryForObject(GET_INVOICE_SQL, this::mapRowToInvoice, invoiceId);
    }catch(EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public void deleteInvoice(int invoiceId) {
        jdbcTemplate.update(DELETE_INVOICE_SQL, invoiceId );
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return jdbcTemplate.query(GET_ALL_INVOICES_SQL, this::mapRowToInvoice);
    }


}
