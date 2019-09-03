package com.company.UlricTodmanU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class SalesTaxRate {

    @NotEmpty(message = "State must not be null and must have a length greater than zero")
    @Size(min=2,max = 2, message = "State must be 2 character abbreviation")
    private String state;
    @NotEmpty(message = "Rate must not be null and must have a value greater than zero")
    private BigDecimal rate;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesTaxRate that = (SalesTaxRate) o;
        return state.equals(that.state) &&
                rate.equals(that.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(state, rate);
    }
}
