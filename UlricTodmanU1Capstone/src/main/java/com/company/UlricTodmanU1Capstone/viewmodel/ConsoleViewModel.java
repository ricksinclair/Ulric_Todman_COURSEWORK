package com.company.UlricTodmanU1Capstone.viewmodel;

import com.company.UlricTodmanU1Capstone.model.Invoice;

import java.math.BigDecimal;
import java.util.Objects;

public class ConsoleViewModel extends ViewModel {
    private String model;
    private String manufacturer;
    private String memoryAmount;
    private String processor;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return getModel().equals(that.getModel()) &&
                getManufacturer().equals(that.getManufacturer()) &&
                getMemoryAmount().equals(that.getMemoryAmount()) &&
                getProcessor().equals(that.getProcessor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getModel(), getManufacturer(), getMemoryAmount(), getProcessor());
    }
}
