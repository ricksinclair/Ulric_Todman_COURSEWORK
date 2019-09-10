package com.company.UlricTodmanU1Capstone.viewmodel;

import com.company.UlricTodmanU1Capstone.model.Invoice;

import java.util.Objects;

public abstract class ViewModel {
    private Invoice invoice;

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewModel viewModel = (ViewModel) o;
        return getInvoice().equals(viewModel.getInvoice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoice());
    }
}
