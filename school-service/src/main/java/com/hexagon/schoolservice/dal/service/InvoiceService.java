package com.hexagon.schoolservice.dal.service;

import com.hexagon.schoolservice.dal.entity.Invoice;
import java.util.List;

public interface InvoiceService {

    public Invoice saveInvoice(Invoice inv);
    public Invoice updateInvoice(Invoice inv, Long invId);
    public void deleteInvoice(Long invId);
    public Invoice getOneInvoice(Long invId);
    public List<Invoice> getAllInvoices();
}