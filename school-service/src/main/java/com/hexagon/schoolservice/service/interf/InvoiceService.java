package com.hexagon.schoolservice.service.interf;

import com.hexagon.schoolservice.entity.Invoice;
import java.util.List;

public interface InvoiceService {

    public Invoice saveInvoice(Invoice inv);
    public Invoice updateInvoice(Invoice inv, Long invId);
    public void deleteInvoice(Long invId);
    public Invoice getOneInvoice(Long invId);
    public List<Invoice> getAllInvoices();
}