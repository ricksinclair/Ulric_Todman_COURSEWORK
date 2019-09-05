package com.company.UlricTodmanU1Capstone.viewmodel;

import com.company.UlricTodmanU1Capstone.model.Invoice;
import com.company.UlricTodmanU1Capstone.model.TShirt;

import java.math.BigDecimal;
import java.util.Objects;

public class TShirtViewModel extends Invoice {

    private String size;
    private String description;
    private String color;

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirtViewModel that = (TShirtViewModel) o;
        return getSize().equals(that.getSize()) &&
                getDescription().equals(that.getDescription()) &&
                getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSize(), getDescription(), getColor());
    }
}
