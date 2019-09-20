package com.company.JpaReview.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="invoice")

public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;
    private int customerId;
    private Date orderDate;
    private Date pickupDate;
    private Date returnDate;
    private BigDecimal lateFee;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }
}
