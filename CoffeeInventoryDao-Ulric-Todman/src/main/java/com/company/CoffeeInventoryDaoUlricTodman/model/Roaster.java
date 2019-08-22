package com.company.CoffeeInventoryDaoUlricTodman.model;

import java.util.Objects;

public class Roaster {

    private int roasterId;
    private String name;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String phone;
    private String email;
    private String note;

    public int getRoasterId() {
        return roasterId;
    }

    public void setRoasterId(int roasterId) {
        this.roasterId = roasterId;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roaster roaster = (Roaster) o;
        return getRoasterId() == roaster.getRoasterId() &&
                getName().equals(roaster.getName()) &&
                getStreet().equals(roaster.getStreet()) &&
                getCity().equals(roaster.getCity()) &&
                getState().equals(roaster.getState()) &&
                getPostalCode().equals(roaster.getPostalCode()) &&
                getPhone().equals(roaster.getPhone()) &&
                getEmail().equals(roaster.getEmail()) &&
                getNote().equals(roaster.getNote());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoasterId(), getName(), getStreet(), getCity(), getState(), getPostalCode(), getPhone(), getEmail(), getNote());
    }
}
