package com.company.UlricTodmanU1Capstone.model;

import com.company.UlricTodmanU1Capstone.viewmodel.CustomerOrder;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Objects;

public class    Invoice extends CustomerOrder {
    private int invoiceId;
    @NotNull(message = "must include unit price")
    private BigDecimal unitPrice;
    @NotNull(message = "must include subtotal")
    private BigDecimal subTotal;
    @NotNull(message = "must include tax")
    private BigDecimal tax;
    @NotNull(message = "must include processingFee")
    private BigDecimal processingFee;
    @NotNull(message = "must include total")
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
