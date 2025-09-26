package com.hexagon.paymentservice.dal.service;

import com.hexagon.paymentservice.dal.entity.InvoiceEntity;

import java.util.List;

public interface InvoiceService {

    InvoiceEntity create(InvoiceEntity inv);
    InvoiceEntity update(InvoiceEntity inv, Long invId);
    void delete(Long invId);
    InvoiceEntity findById(Long invId);
    List<InvoiceEntity> read();
}