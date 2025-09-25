package com.hexagon.paymentservice.dal.repository;

import com.hexagon.schoolservice.dal.entity.InvoiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<InvoiceEntity, Long> {
}
