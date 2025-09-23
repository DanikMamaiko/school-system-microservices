package com.hexagon.schoolservice.controller;

import com.hexagon.schoolservice.dal.entity.Invoice;
import com.hexagon.schoolservice.dal.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Invoice saveInvoice(@RequestBody Invoice inv) {
        return invoiceService.saveInvoice(inv);
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices(){
        return ResponseEntity.ok(invoiceService.getAllInvoices());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Invoice getOneInvoice(@PathVariable Long id) {
        return invoiceService.getOneInvoice(id);
    }

    @PutMapping("/{id}")
    public Invoice updateInvoice(@RequestBody Invoice inv, @PathVariable Long id) {
        return invoiceService.updateInvoice(inv, id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.ok("Invoice with id: " + id + " was deleted!");
    }
}
