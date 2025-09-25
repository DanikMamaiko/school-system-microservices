package com.hexagon.schoolservice.dal.service;

import com.hexagon.schoolservice.dal.entity.Invoice;
import java.util.List;

public interface InvoiceService {

    Invoice create(Invoice inv);
    Invoice update(Invoice inv, Long invId);
    void delete(Long invId);
    Invoice findById(Long invId);
    List<Invoice> read();
}