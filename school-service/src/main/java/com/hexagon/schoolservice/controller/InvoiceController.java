package com.hexagon.schoolservice.controller;

import com.hexagon.schoolservice.entity.Invoice;
import com.hexagon.schoolservice.service.interf.InvoiceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    InvoiceService invoiceService;

    @PostMapping("/saveInv")
    public Invoice saveInvoice(@RequestBody Invoice inv) {
        return invoiceService.saveInvoice(inv);
    }

    @GetMapping("/allInv")
    public ResponseEntity<List<Invoice>> getAllInvoices(){
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @GetMapping("/getOne/{id}")
    public Invoice getOneInvoice(@PathVariable Long id) {
        return invoiceService.getOneInvoice(id);
    }

    @PutMapping("/modify/{id}")
    public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Long id) {
        return invoiceService.updateInvoice(inv, id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return "Employee with id: "+id+ " Deleted !";
    }
}
