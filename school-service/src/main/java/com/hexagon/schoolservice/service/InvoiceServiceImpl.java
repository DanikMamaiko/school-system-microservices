package com.hexagon.schoolservice.service;

import com.hexagon.schoolservice.entity.Invoice;
import com.hexagon.schoolservice.exception.InvoiceNotFoundException;
import com.hexagon.schoolservice.repository.InvoiceRepository;
import com.hexagon.schoolservice.service.interf.InvoiceService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepo;

    @Override
    public Invoice saveInvoice(Invoice inv) {
        return invoiceRepo.save(inv);
    }

    @Override
    @CachePut(value = "Invoice", key="#invId")
    public Invoice updateInvoice(Invoice inv, Long invId) {
        Invoice invoice = invoiceRepo.findById(invId)
            .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoice.setInvAmount(inv.getInvAmount());
        invoice.setInvName(inv.getInvName());
        return invoiceRepo.save(invoice);
    }

    @Override
    @CacheEvict(value="Invoice", key="#invId")
    public void deleteInvoice(Long invId) {
        Invoice invoice = invoiceRepo.findById(invId)
            .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        invoiceRepo.delete(invoice);
    }

    @Override
    @Cacheable(value="Invoice", key="#invId")
    public Invoice getOneInvoice(Long invId) {
        Invoice invoice = invoiceRepo.findById(invId)
            .orElseThrow(() -> new InvoiceNotFoundException("Invoice Not Found"));
        return invoice;
    }

    @Override
    @Cacheable(value="Invoice")
    public List<Invoice> getAllInvoices() {
        return invoiceRepo.findAll();
    }
}
