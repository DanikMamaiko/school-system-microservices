package com.hexagon.schoolservice.dal.service.impl;

import com.hexagon.schoolservice.dal.entity.Invoice;
import com.hexagon.schoolservice.dal.service.InvoiceService;
import com.hexagon.schoolservice.exception.InvoiceNotFoundException;
import com.hexagon.schoolservice.dal.repository.InvoiceRepository;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepo;

    @Override
    @Transactional
    public Invoice create(Invoice inv) {
        return invoiceRepo.save(inv);
    }

    @Override
    @CachePut(value = "Invoice", key = "#id")
    @Transactional
    public Invoice update(Invoice inv, Long id) {
        Invoice invoice = invoiceRepo.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoice.setInvAmount(inv.getInvAmount());
        invoice.setInvName(inv.getInvName());
        return invoiceRepo.save(invoice);
    }

    @Override
    @CacheEvict(value="Invoice", key="#id")
    @Transactional
    public void delete(Long id) {
        Invoice invoice = invoiceRepo.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoiceRepo.delete(invoice);
    }

    @Override
    @Cacheable(value="Invoice", key="#id")
    @Transactional(readOnly = true)
    public Invoice findById(Long id) {
        return invoiceRepo.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
    }

    @Override
    @Cacheable(value="Invoice")
    @Transactional(readOnly = true)
    public List<Invoice> read() {
        return invoiceRepo.findAll();
    }
}
