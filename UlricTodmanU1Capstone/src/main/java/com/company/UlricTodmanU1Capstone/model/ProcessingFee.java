package com.company.UlricTodmanU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class ProcessingFee {
    @NotEmpty(message = "Product type must not be null and must have a length greater than zero")
    @Size(max = 20, message = "Product type must be 20 characters or less")
    private String productType;
    @NotEmpty(message = "Fee must not be null and must have a value greater than zero")
    private BigDecimal fee;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessingFee that = (ProcessingFee) o;
        return productType.equals(that.productType) &&
                fee.equals(that.fee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productType, fee);
    }
}
