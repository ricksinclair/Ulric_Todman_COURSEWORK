package com.company.UlricTodmanU1Capstone.model;

import com.company.UlricTodmanU1Capstone.model.interfaces.Product;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class Console implements Product {

    private int consoleId;
    @NotEmpty(message = "Model must not be null and must have a length greater than zero")
    @Size(max = 50, message = "Model must be 50 characters or less")
    private String model;
    @NotEmpty(message = "Manufacturer must not be null and must have a length greater than zero")
    @Size(max = 50, message = "Manufacturer must be 50 characters or less")
    private String manufacturer;
    @NotEmpty(message = "Memory amount must not be null and must have a length greater than zero")
    @Size(max = 50, message = "Memory amount must be 20 characters or less")
    private String memoryAmount;
    @NotEmpty(message = "Processor must not be null and must have a length greater than zero")
    @Size(max = 20, message = "Processor must be 20 characters or less")
    private String processor;
    @NotNull(message = "Price must not be null and must be a non-zero value")
    private BigDecimal price;
    @NotNull(message = "Quantity must not be null")
    private int quantity;


    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int consoleId) {
        this.consoleId = consoleId;
    }

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
        Console console = (Console) o;
        return consoleId == console.consoleId &&
                quantity == console.quantity &&
                model.equals(console.model) &&
                manufacturer.equals(console.manufacturer) &&
                memoryAmount.equals(console.memoryAmount) &&
                processor.equals(console.processor) &&
                price.equals(console.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
