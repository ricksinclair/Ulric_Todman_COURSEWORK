package com.company.UlricTodmanU1Capstone.model.interfaces;

import java.math.BigDecimal;

public interface Product {
    BigDecimal getPrice();
    int getQuantity();
    void setPrice(BigDecimal price);
    void setQuantity(int quantity);
}
