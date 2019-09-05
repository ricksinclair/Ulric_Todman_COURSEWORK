package com.company.UlricTodmanU1Capstone.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class CustomerOrder {

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
    @NotEmpty(message = "Quantity must be included and greater than zero")
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrder that = (CustomerOrder) o;
        return getItemId() == that.getItemId() &&
                getQuantity() == that.getQuantity() &&
                getName().equals(that.getName()) &&
                getStreet().equals(that.getStreet()) &&
                getCity().equals(that.getCity()) &&
                getState().equals(that.getState()) &&
                getZipCode().equals(that.getZipCode()) &&
                getItemType().equals(that.getItemType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStreet(), getCity(), getState(), getZipCode(), getItemType(), getItemId(), getQuantity());
    }
}
