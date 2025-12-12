package com.alabado.lab7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alabado.lab7.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
