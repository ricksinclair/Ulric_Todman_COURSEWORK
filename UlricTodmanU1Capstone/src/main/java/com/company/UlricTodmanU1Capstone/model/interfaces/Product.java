package com.company.UlricTodmanU1Capstone.model.interfaces;

import java.math.BigDecimal;

public interface Product {
    BigDecimal getPrice();

    void setPrice(BigDecimal price);

    int getQuantity();

    void setQuantity(int quantity);
}
