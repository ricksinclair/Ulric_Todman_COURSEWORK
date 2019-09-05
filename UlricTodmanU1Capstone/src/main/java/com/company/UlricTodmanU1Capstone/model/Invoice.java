package com.company.UlricTodmanU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Invoice extends CustomerOrder {
    private int invoiceId;
//    @NotEmpty(message = "Name must not be null and must have a length greater than zero")
//    @Size(max = 80, message = "Name must be 80 characters or less")
//    private String name;
//    @NotEmpty(message = "Street must not be null and must have a length greater than zero")
//    @Size(max = 30, message = "Street must be 30 characters or less")
//    private String street;
//    @NotEmpty(message = "City must not be null and must have a length greater than zero")
//    @Size(max = 30, message = "City must be 30 characters or less")
//    private String city;
//    @NotEmpty(message = "Street must not be null and must have a length greater than zero")
//    @Size(min = 2, max = 2, message = "State has length of 2. Please enter 2-character state abbreviation.")
//    private String state;
//    @NotEmpty(message = "Zip code  must not be null and must have a length greater than zero")
//    @Size(min = 5, max = 5, message = "Zip code  must be exactly 5 characters")
//    private String zipCode;
//    @NotEmpty(message = "Item type must not be null and must have a length greater than zero")
//    @Size(max = 20, message = "Item type must be 20 characters or less")
//    private String itemType;
//    @NotEmpty(message = "Item id must not be null and must have a length greater than zero")
//    private int itemId;
    @NotEmpty(message = "must include unit price")
    private BigDecimal unitPrice;

    @NotEmpty(message = "must include subtotal")
    private BigDecimal subTotal;
    @NotEmpty(message = "must include tax")
    private BigDecimal tax;
    @NotEmpty(message = "must include processingFee")
    private BigDecimal processingFee;
    @NotEmpty(message = "must include total")
    private BigDecimal total;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(BigDecimal processingFee) {
        this.processingFee = processingFee;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Invoice invoice = (Invoice) o;
        return getInvoiceId() == invoice.getInvoiceId() &&
                getUnitPrice().equals(invoice.getUnitPrice()) &&
                getSubTotal().equals(invoice.getSubTotal()) &&
                getTax().equals(invoice.getTax()) &&
                getProcessingFee().equals(invoice.getProcessingFee()) &&
                getTotal().equals(invoice.getTotal());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getInvoiceId(), getUnitPrice(), getSubTotal(), getTax(), getProcessingFee(), getTotal());
    }
}
