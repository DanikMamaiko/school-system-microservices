package com.hexagon.paymentservice.dal.service.impl;

import com.hexagon.schoolservice.dal.entity.InvoiceEntity;
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
    public InvoiceEntity create(InvoiceEntity inv) {
        return invoiceRepo.save(inv);
    }

    @Override
    @CachePut(value = "Invoice", key = "#id")
    @Transactional
    public InvoiceEntity update(InvoiceEntity inv, Long id) {
        InvoiceEntity invoiceEntity = invoiceRepo.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoiceEntity.setInvAmount(inv.getInvAmount());
        invoiceEntity.setInvName(inv.getInvName());
        return invoiceRepo.save(invoiceEntity);
    }

    @Override
    @CacheEvict(value="Invoice", key="#id")
    @Transactional
    public void delete(Long id) {
        InvoiceEntity invoiceEntity = invoiceRepo.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoiceRepo.delete(invoiceEntity);
    }

    @Override
    @Cacheable(value="Invoice", key="#id")
    @Transactional(readOnly = true)
    public InvoiceEntity findById(Long id) {
        return invoiceRepo.findById(id)
                .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
    }

    @Override
    @Cacheable(value="Invoice")
    @Transactional(readOnly = true)
    public List<InvoiceEntity> read() {
        return invoiceRepo.findAll();
    }
}
