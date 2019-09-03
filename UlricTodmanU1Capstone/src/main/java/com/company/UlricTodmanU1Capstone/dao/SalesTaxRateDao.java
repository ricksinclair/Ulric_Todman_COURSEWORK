package com.company.UlricTodmanU1Capstone.dao;

import com.company.UlricTodmanU1Capstone.model.SalesTaxRate;

public interface SalesTaxRateDao {

    SalesTaxRate addTaxRate(SalesTaxRate salesTaxRate);

    SalesTaxRate getTaxRate(String state);

    void updateTaxRate(SalesTaxRate salesTaxRate);

    void deleteTaxRate(String state);
}
