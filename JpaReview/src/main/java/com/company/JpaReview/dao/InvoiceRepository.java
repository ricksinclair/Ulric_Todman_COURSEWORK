package com.company.JpaReview.dao;

import com.company.JpaReview.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
