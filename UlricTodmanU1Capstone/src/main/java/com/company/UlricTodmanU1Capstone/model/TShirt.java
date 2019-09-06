package com.company.UlricTodmanU1Capstone.model;

import com.company.UlricTodmanU1Capstone.model.interfaces.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class TShirt implements Product {
    private int tShirtId;
    @NotEmpty(message = "Size must not be null and must have a length greater than zero")
    @Size(max = 20, message = "Size must be 20 characters or less")
    private String size;
    @NotEmpty(message = "Color must not be null and must have a length greater than zero")
    @Size(max = 20, message = "Color must be 20 characters or less")
    private String color;
    @NotEmpty(message = "Description must not be null and must have a length greater than zero")
    @Size(max = 255, message = "Description must be 255 characters or less")
    private String description;
    @NotEmpty(message = "Price must not be null and must have a value greater than zero")
    private BigDecimal price;
    @NotNull(message = "Quantity must not be null")
    private int quantity;

    public int getTShirtId() {
        return tShirtId;
    }

    public void setTShirtId(int tShirtId) {
        this.tShirtId = tShirtId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TShirt tShirt = (TShirt) o;
        return tShirtId == tShirt.tShirtId &&
                quantity == tShirt.quantity &&
                size.equals(tShirt.size) &&
                color.equals(tShirt.color) &&
                description.equals(tShirt.description) &&
                price.equals(tShirt.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tShirtId, size, color, description, price, quantity);
    }
}
