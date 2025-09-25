package com.hexagon.schoolservice.dal.repository;

import com.hexagon.schoolservice.dal.entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
