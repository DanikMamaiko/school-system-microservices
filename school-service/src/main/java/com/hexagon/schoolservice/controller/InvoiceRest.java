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
public class InvoiceRest {

    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Invoice> create(@RequestBody Invoice inv) {
        Invoice saved = invoiceService.create(inv);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> read(){
        return ResponseEntity.ok(invoiceService.read());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> findById(@PathVariable Long id) {
        Invoice invoice = invoiceService.findById(id);
        return ResponseEntity.ok(invoice);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> update(@RequestBody Invoice inv, @PathVariable Long id) {
        Invoice updated = invoiceService.update(inv, id);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        invoiceService.delete(id);
        return ResponseEntity.ok("Invoice with id: " + id + " was deleted!");
    }
}