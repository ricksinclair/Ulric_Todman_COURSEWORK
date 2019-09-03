package com.company.UlricTodmanU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Invoice {
    private int invoiceId;
    @NotEmpty(message = "Name must not be null and must have a length greater than zero")
    @Size(max = 80, message = "Name must be 80 characters or less")
    private String name;
    @NotEmpty(message = "Street must not be null and must have a length greater than zero")
    @Size(max = 30, message = "Street must be 30 characters or less")
    private String street;
    @NotEmpty(message = "City must not be null and must have a length greater than zero")
    @Size(max = 30, message = "City must be 30 characters or less")
    private String city;
    @NotEmpty(message = "Street must not be null and must have a length greater than zero")
    @Size(min = 2, max = 2, message = "State has length of 2. Please enter 2-character state abbreviation.")
    private String state;
    @NotEmpty(message = "Zip code  must not be null and must have a length greater than zero")
    @Size(min = 5, max = 5, message = "Zip code  must be exactly 5 characters")
    private String zipCode;
    @NotEmpty(message = "Item type must not be null and must have a length greater than zero")
    @Size(max = 20, message = "Item type must be 20 characters or less")
    private String itemType;
    @NotEmpty(message = "Item id must not be null and must have a length greater than zero")
    private int itemId;
    private BigDecimal unitPrice;
    @NotEmpty(message = "Quantity must be included and greater than zero")
    private int quantity;
    private BigDecimal subTotal;
    private BigDecimal tax;
    private BigDecimal processingFee;
    private BigDecimal total;


    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId &&
                itemId == invoice.itemId &&
                quantity == invoice.quantity &&
                name.equals(invoice.name) &&
                street.equals(invoice.street) &&
                city.equals(invoice.city) &&
                state.equals(invoice.state) &&
                zipCode.equals(invoice.zipCode) &&
                itemType.equals(invoice.itemType) &&
                unitPrice.equals(invoice.unitPrice) &&
                subTotal.equals(invoice.subTotal) &&
                tax.equals(invoice.tax) &&
                processingFee.equals(invoice.processingFee) &&
                total.equals(invoice.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, name, street, city, state, zipCode, itemType, itemId, unitPrice, quantity, subTotal, tax, processingFee, total);
    }
}
